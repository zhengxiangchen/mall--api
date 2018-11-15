package cn.sihai.soft.api.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sihai.soft.api.dao.GoodsTypeDao;
import cn.sihai.soft.api.entity.GoodsTypeEntity;

/**
 * 已失效
 * 创建人：Jarvan   
 * 创建时间：2018年11月14日 上午11:23:40
 */
@Service
public class GoodsTypeService {
	
	@Autowired
	private GoodsTypeDao goodsTypeDao;
	
	
	/**
	 * 取得全部的一级目录
	 * @return
	 */
	public ArrayList<GoodsTypeEntity> findAll() {
		return (ArrayList<GoodsTypeEntity>) goodsTypeDao.findAll();
	}


	/**
	 * 根据id获取对象
	 * @param id
	 * @return
	 */
	public GoodsTypeEntity findOne(String id) {
		return goodsTypeDao.getOne(Integer.valueOf(id));
	}
	
	
	

}
