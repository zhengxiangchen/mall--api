package cn.sihai.soft.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.sihai.soft.api.entity.AddressEntity;

public interface AddressDao extends JpaRepository<AddressEntity, Integer>{

	@Query("from AddressEntity where openid = ?1")
	AddressEntity getAddress(String openid);

}
