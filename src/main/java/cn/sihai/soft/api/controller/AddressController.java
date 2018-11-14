package cn.sihai.soft.api.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.sihai.soft.api.entity.AddressEntity;
import cn.sihai.soft.api.service.AddressService;

@RestController
@RequestMapping("${basepath}/address")
public class AddressController {
	public static Logger logger = LogManager.getLogger(AddressController.class);
	
	
	@Autowired
	private AddressService addressService;
	
	/**
	 * 根据用户openid查找地址
	 * @param openid
	 * @return
	 */
	@RequestMapping(value="/getAddress", method = RequestMethod.GET)
	public AddressEntity getAddress(@RequestParam String openid){
		AddressEntity address = addressService.getAddress(openid);
		return address;
		
	}
	
	/**
	 * 保存用户地址信息
	 */
	@RequestMapping(value="/save", method = RequestMethod.GET)
	public void save(@RequestParam String openid, @RequestParam String name, @RequestParam String phone, @RequestParam String detail){
		AddressEntity address = new AddressEntity();
		
		address.setOpenid(openid);
		address.setName(name);
		address.setPhone(phone);
		address.setDetail(detail);
		
		addressService.saveOrUpdate(address);
		
	}

}
