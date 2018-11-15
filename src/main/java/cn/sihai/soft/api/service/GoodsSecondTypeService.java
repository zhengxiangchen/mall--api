package cn.sihai.soft.api.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sihai.soft.api.dao.GoodsSecondTypeDao;
import cn.sihai.soft.api.entity.GoodsSecondTypeEntity;

/**
 * 已失效
 * 创建人：Jarvan   
 * 创建时间：2018年11月14日 上午11:23:40
 */
@Service
public class GoodsSecondTypeService {
	
	@Autowired
	private GoodsSecondTypeDao goodsSecondTypeDao;

	
	
	/**
	 * 根据一级目录查找对应的二级目录
	 * @param id
	 * @return
	 */
	public ArrayList<GoodsSecondTypeEntity> findByFirstType(String id) {
		return goodsSecondTypeDao.findByFirstType(id);
	}


	/**
	 * 根据id取对象
	 * @param id
	 * @return
	 */
	public GoodsSecondTypeEntity findOne(String id) {
		return goodsSecondTypeDao.getOne(Integer.valueOf(id));
	}


	/**
	 * 根据name模糊查询
	 * @param name
	 * @return
	 */
	public ArrayList<GoodsSecondTypeEntity> search(String name) {
		return goodsSecondTypeDao.search(name);
	}

}
