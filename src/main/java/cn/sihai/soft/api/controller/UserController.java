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

import cn.sihai.soft.api.entity.UserEntity;
import cn.sihai.soft.api.service.UserService;



@RestController
@RequestMapping("${basepath}/user")
public class UserController {
	public static Logger logger = LogManager.getLogger(UserController.class);
	
	
	@Autowired
	private UserService userService;
	
	
	/**
	 * 根据用户openid查找是否有该用户
	 * @param openid
	 * @return
	 */
	@RequestMapping(value="/getUser", method = RequestMethod.GET)
	public boolean getUser(@RequestParam String openid){
		UserEntity user = userService.getUser(openid);
		
		if(user == null){
			return false;
		}else{
			return true;
		}
	}
	
	
	/**
	 * 根据用户openid查找该用户
	 * @param openid
	 * @return
	 */
	@RequestMapping(value="/getUserByOpenid", method = RequestMethod.GET)
	public UserEntity getUserByOpenid(@RequestParam String openid){
		UserEntity user = userService.getUser(openid);
		return user;
	}
	
	/**
	 * 修改登录时间
	 * @param openid
	 */
	@RequestMapping(value="/updateTime", method = RequestMethod.GET)
	public void updateTime(@RequestParam String openid){
		UserEntity user = userService.getUser(openid);
		
		user.setLoginTime(new Timestamp(System.currentTimeMillis()));
		
		userService.saveOrUpdate(user);
	}
	
	/**
	 * 保存用户
	 * @param openid
	 */
	@RequestMapping(value="/save", method = RequestMethod.GET)
	public void save(@RequestParam String openid, @RequestParam String avatarUrl, @RequestParam String city, @RequestParam String country,
			@RequestParam String gender, @RequestParam String nickName, @RequestParam String province){
		
		UserEntity user = new UserEntity();
		user.setOpenid(openid);
		user.setAvatarUrl(avatarUrl);
		user.setCity(city);
		user.setCountry(country);
		user.setGender(gender);
		user.setNickName(nickName);
		user.setProvince(province);
		user.setLoginTime(new Timestamp(System.currentTimeMillis()));
		
		userService.saveOrUpdate(user);
	}
	
	
	/**
	 * 返回最近登录小程序的用户信息
	 * @return
	 */
	@RequestMapping(value="/getLoginUserList", method = RequestMethod.GET)
	public ArrayList<UserEntity> getLoginUserList(){
		
		ArrayList<UserEntity> ret = userService.getLoginUserList();
		
		return ret;
	}
	

}
