package cn.sihai.soft.api.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sihai.soft.api.dao.UserDao;
import cn.sihai.soft.api.entity.UserEntity;


@Service
public class UserService{

	@Autowired
	private UserDao userDao;
	
	/**
	 * 保存/修改用户信息
	 * @param user
	 */
	public void saveOrUpdate(UserEntity user){
		userDao.save(user);
    }

	
	public UserEntity getUser(String openid) {
		return userDao.getUser(openid);
	}


	/**
	 * 返回最近登录小程序的用户信息
	 * @return
	 */
	public ArrayList<UserEntity> getLoginUserList() {
		return userDao.getLoginUserList();
	}


}
