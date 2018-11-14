package cn.sihai.soft.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sihai.soft.api.dao.AddressDao;
import cn.sihai.soft.api.entity.AddressEntity;

@Service
public class AddressService {
	
	@Autowired
	private AddressDao addressDao;
	
	/**
	 * 保存/修改用户信息
	 * @param address
	 */
	public void saveOrUpdate(AddressEntity address){
		addressDao.save(address);
    }
	
	public AddressEntity getAddress(String openid) {
		return addressDao.getAddress(openid);
	}

}
