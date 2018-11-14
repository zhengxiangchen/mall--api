package cn.sihai.soft.api.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.sihai.soft.api.entity.UserEntity;


public interface UserDao extends CrudRepository<UserEntity, Integer>{

	@Query("from UserEntity where openid = ?")
	UserEntity getUser(String openid);

	@Query(nativeQuery=true, value = "select * from mini_user order by login_time desc limit 20")
	ArrayList<UserEntity> getLoginUserList();

}
