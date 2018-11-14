package cn.sihai.soft.api.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.sihai.soft.api.entity.OrderEntity;

public interface OrderDao extends CrudRepository<OrderEntity, Integer> {

	@Query("from OrderEntity where openid = ?")
	ArrayList<OrderEntity> getListByUser(String openid);

	@Query("from OrderEntity where uuid = ?")
	OrderEntity getByUuid(String uuid);

}
