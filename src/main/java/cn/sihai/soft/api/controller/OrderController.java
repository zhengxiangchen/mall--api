package cn.sihai.soft.api.controller;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.sihai.soft.api.entity.OrderEntity;
import cn.sihai.soft.api.entity.ReturnOrderEntity;
import cn.sihai.soft.api.service.OrderService;

@RestController
@RequestMapping("${basepath}/order")
public class OrderController {
	
public static Logger logger = LogManager.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderService;
	
	
	
	/**
	 * 根据UUid查询
	 * @return
	 */
	@RequestMapping(value="/getByUuid", method = RequestMethod.GET)
	public ReturnOrderEntity getByUuid(@RequestParam String uuid){
		ReturnOrderEntity ret = new ReturnOrderEntity();
		
		OrderEntity entity = orderService.getByUuid(uuid);
		
		ret.setUuid(entity.getUuid());
		ret.setOpenid(entity.getOpenid());
		ret.setAddress(JSONObject.parseObject(entity.getAddress()));
		ret.setGoods(JSONArray.parseArray(entity.getGoods()));
		ret.setMoney(entity.getMoney());
		ret.setNickName(entity.getNickName());
		ret.setOrderStatus(entity.getOrderStatus());
		ret.setCreateTime(entity.getCreateTime());
		return ret;
	}
	
	
	
	/**
	 * 修改订单状态
	 * @return
	 */
	@RequestMapping(value="/updateOrderStatus", method = RequestMethod.GET)
	public void updateOrderStatus(@RequestParam String uuid){
		
		OrderEntity entity = orderService.getByUuid(uuid);
		entity.setOrderStatus("已采购");
		orderService.save(entity);
	}
	
	
	
	/**
	 * 保存订单信息返回uuid作为订单编号
	 * @return
	 */
	@RequestMapping(value="/save", method = RequestMethod.GET)
	public String save(@RequestParam String openid, @RequestParam String nickName, @RequestParam String goods, @RequestParam String address, 
			@RequestParam String money, @RequestParam String orderStatus){
		
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setOpenid(openid);
		orderEntity.setAddress(address);
		orderEntity.setGoods(goods);
		orderEntity.setMoney(money);
		orderEntity.setNickName(nickName);
		orderEntity.setOrderStatus(orderStatus);
		orderEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));
		
		String uuid = orderService.save(orderEntity);
		return uuid;
	}
	
	
	
	/**
	 * 获取全部订单信息
	 * @return
	 */
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	public ArrayList<OrderEntity> getAll(){
		
		ArrayList<OrderEntity> list = orderService.getAll();
		
		return list;
	}
	
	
	/**
	 * 根据用户查询订单
	 * @return
	 */
	@RequestMapping(value="/getListByUser", method = RequestMethod.GET)
	public ArrayList<OrderEntity> getListByUser(@RequestParam String openid){
		
		ArrayList<OrderEntity> list = orderService.getListByUser(openid);
		
		return list;
	}

}
