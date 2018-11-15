package cn.sihai.soft.api.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sihai.soft.api.dao.GoodsAllTypeDao;
import cn.sihai.soft.api.entity.GoodsAllTypeEntity;

@Service
public class GoodsAllTypeService {
	@Autowired
	private GoodsAllTypeDao goodsAllTypeDao;

	
	/**
	 * 取得所有一级目录
	 * @return
	 */
	public ArrayList<GoodsAllTypeEntity> getFirst() {
		return goodsAllTypeDao.getFirst();
	}



	/**
	 * 根据一级目录pid获取对应的二级目录
	 * @param pid
	 * @return
	 */
	public ArrayList<GoodsAllTypeEntity> getSecond(String pid) {
		return goodsAllTypeDao.getSecond(Integer.valueOf(pid));
	}


	/**
	 * 根据id获取对象
	 * @param id
	 * @return
	 */
	public GoodsAllTypeEntity findOne(String id) {
		return goodsAllTypeDao.getOne(Integer.valueOf(id));
	}


	/**
	 * name模糊查询
	 * @param name
	 * @return
	 */
	public ArrayList<GoodsAllTypeEntity> search(String name) {
		return goodsAllTypeDao.search(name);
	}

	
	
	
	

}
