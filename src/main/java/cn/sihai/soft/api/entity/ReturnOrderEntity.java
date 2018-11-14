package cn.sihai.soft.api.entity;

import java.sql.Timestamp;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class ReturnOrderEntity {
	
	private String uuid;
	
	private String openid;
	
	private JSONObject address;
	
	private JSONArray goods;
	
	private String money;
	
	private String nickName;
	
	private String orderStatus;
	
	private Timestamp createTime;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public JSONObject getAddress() {
		return address;
	}

	public void setAddress(JSONObject address) {
		this.address = address;
	}

	public JSONArray getGoods() {
		return goods;
	}

	public void setGoods(JSONArray goods) {
		this.goods = goods;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
}
