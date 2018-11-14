package cn.sihai.soft.api.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.sihai.soft.api.entity.AddressEntity;

public interface AddressDao extends CrudRepository<AddressEntity, Integer>{

	@Query("from AddressEntity where openid = ?")
	AddressEntity getAddress(String openid);

}
