package cn.sihai.soft.api.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sihai.soft.api.dao.SwiperImgDao;
import cn.sihai.soft.api.entity.SwiperImgEntity;

@Service
public class SwiperImgService {
	
	@Autowired
	private SwiperImgDao swiperImgDao;
	
	
	public ArrayList<SwiperImgEntity> getAll(){
		return (ArrayList<SwiperImgEntity>) swiperImgDao.findAll();
	}

}
