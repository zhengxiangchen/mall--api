package cn.sihai.soft.api.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sihai.soft.api.dao.OrderDao;
import cn.sihai.soft.api.entity.OrderEntity;

@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao;
	
	
	/**
	 * 保存订单
	 * @param orderEntity
	 */
	public String save(OrderEntity orderEntity){
		orderDao.save(orderEntity);
		return orderEntity.getUuid();
	}


	/**
	 * 全部的订单信息
	 * @return
	 */
	public ArrayList<OrderEntity> getAll() {
		return (ArrayList<OrderEntity>) orderDao.findAll();
	}


	/**
	 * 根据用户查询订单信息
	 * @param openid
	 * @return
	 */
	public ArrayList<OrderEntity> getListByUser(String openid) {
		return orderDao.getListByUser(openid);
	}


	/**
	 * 根据uuid返回对象
	 * @param openid
	 * @return
	 */
	public OrderEntity getByUuid(String uuid) {
		return orderDao.getByUuid(uuid);
	}

}
