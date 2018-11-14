package cn.sihai.soft.api.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "mini_order")
public class OrderEntity {
	@Id
	@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
	@GeneratedValue(generator = "jpa-uuid")
	@Column(name="uuid")
	private String uuid;
	
	@Column(name="openid")
	private String openid;
	
	@Column(name="address")
	private String address;
	
	@Column(name="goods")
	private String goods;
	
	@Column(name="money")
	private String money;
	
	@Column(name="nick_name")
	private String nickName;
	
	@Column(name="order_status")
	private String orderStatus;
	
	@Column(name="create_time")
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
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
