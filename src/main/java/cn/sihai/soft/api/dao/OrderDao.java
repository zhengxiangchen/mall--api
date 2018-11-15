package cn.sihai.soft.api.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.sihai.soft.api.entity.OrderEntity;

public interface OrderDao extends JpaRepository<OrderEntity, Integer> {

	@Query("from OrderEntity where openid = ?1")
	ArrayList<OrderEntity> getListByUser(String openid);

	@Query("from OrderEntity where uuid = ?1")
	OrderEntity getByUuid(String uuid);

}
