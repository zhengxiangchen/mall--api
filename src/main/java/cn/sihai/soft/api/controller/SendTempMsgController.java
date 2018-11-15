package cn.sihai.soft.api.controller;

import java.util.HashMap;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import cn.sihai.soft.api.utils.HttpAccess;
import cn.sihai.soft.api.utils.rabbitmq.Sender;

@RestController
@RequestMapping("${basepath}/sendTempMsg")
public class SendTempMsgController {
	
	@Value("${sendMsg.appid}")
	private String appid;
	
	@Value("${sendMsg.secret}")
	private String secret;
	
	@Value("${sendMsg.template.id}")
	private String template_id;
	
	@Autowired
    private Sender sender;
	
	/**
	 * 发送模板信息给用户，发送订单信息到商家邮箱
	 * @param formid
	 * @param openid
	 * @param orderId
	 * @param money
	 * @param userName
	 * @param phone
	 * @param addressMsg
	 * @param goodsName
	 * @param goodsNumber
	 * @param wxNumber
	 * @return
	 * @throws MessagingException
	 */
	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public String send(@RequestParam String formid, @RequestParam String openid, @RequestParam String orderId,  
					@RequestParam String money,@RequestParam String userName,@RequestParam String phone,
					@RequestParam String addressMsg, @RequestParam String goodsName, @RequestParam String goodsNumber,
					@RequestParam String wxNumber) throws MessagingException{
		
		String access_token_url = "https://api.weixin.qq.com/cgi-bin/token";
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("grant_type", "client_credential");
		params.put("appid", appid);
		params.put("secret", secret);
		
		String ret = HttpAccess.getNameValuePairRequest(access_token_url, params, "utf-8", "access_token");
		
		JSONObject retJson = JSONObject.parseObject(ret);
		String access_token = retJson.getString("access_token");
		
		String send_temp_msg_url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=" + access_token;
		
		JSONObject obj = new JSONObject();
		JSONObject value = new JSONObject();
		value.put("value", orderId);
		obj.put("keyword1", value);
		value = new JSONObject();
		value.put("value", goodsName);
		obj.put("keyword2", value);
		value = new JSONObject();
		value.put("value", goodsNumber);
		obj.put("keyword3", value);
		value = new JSONObject();
		value.put("value", money);
		obj.put("keyword4", value);
		value = new JSONObject();
		value.put("value", userName);
		obj.put("keyword5", value);
		value = new JSONObject();
		value.put("value", phone);
		obj.put("keyword6", value);
		value = new JSONObject();
		value.put("value", addressMsg);
		obj.put("keyword7", value);
		
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("touser", openid);
		requestParams.put("template_id", template_id);
		requestParams.put("form_id", formid);
		requestParams.put("data", obj);
		
		System.out.println("requestParams = " + requestParams.toJSONString());
		
		String sendRet = HttpAccess.postJsonRequest(send_temp_msg_url, requestParams.toJSONString(), "utf-8", "send_temp_msg");
		
		JSONObject sendRetJson = JSONObject.parseObject(sendRet);
		String errmsg = sendRetJson.getString("errmsg");
		if(errmsg.equals("ok")){
			StringBuffer sb = new StringBuffer();
			sb.append("<div>");
			sb.append("订单号:");
			sb.append(orderId);
			sb.append("</div>");
			
			sb.append("<div>");
			sb.append("微信号:");
			sb.append(wxNumber);
			sb.append("</div>");
			
			sb.append("<div>");
			sb.append("商品名称:");
			sb.append(goodsName);
			sb.append("</div>");
			
			sb.append("<div>");
			sb.append("商品数量:");
			sb.append(goodsNumber);
			sb.append("</div>");
			
			sb.append("<div>");
			sb.append("金额:");
			sb.append(money);
			sb.append("</div>");
			
			sb.append("<div>");
			sb.append("收货人:");
			sb.append(userName);
			sb.append("</div>");
			
			sb.append("<div>");
			sb.append("联系电话:");
			sb.append(phone);
			sb.append("</div>");
			
			sb.append("<div>");
			sb.append("地址:");
			sb.append(addressMsg);
			sb.append("</div>");
			
			//把发送email的任务交给消息中间件rabbitmq
			sender.sendEmail(sb.toString());
			
			//通知后台有新订单了
			sender.sendNewOrder(orderId);
			
			return "success";
		}else{
			return errmsg;
		}
		
	}
	
	
	
	@RequestMapping(value = "/sendTest", method = RequestMethod.GET)
	public String sendTest(){
		sender.sendNewOrder("id:123456");
		return "success";
	}

}
