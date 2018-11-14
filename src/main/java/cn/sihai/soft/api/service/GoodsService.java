package cn.sihai.soft.api.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sihai.soft.api.dao.GoodsDao;
import cn.sihai.soft.api.entity.GoodsEntity;

@Service
public class GoodsService {
	
	@Autowired
	private GoodsDao goodsDao;

	/**
	 * 取得二级目录下的所有商品
	 * @param goodsSecondTypeId
	 * @return
	 */
	public ArrayList<GoodsEntity> findBySecondType(String goodsSecondTypeId) {
		return goodsDao.findBySecondType(goodsSecondTypeId);
	}
	
	
	/**
	 * 获取num个首页显示的商品
	 * @param num
	 * @return
	 */
	public ArrayList<GoodsEntity> getIndexList(Integer num) {
		return goodsDao.getIndexList(num);
	}


	/**
	 * 根据name模糊查询
	 * @param name
	 * @return
	 */
	public ArrayList<GoodsEntity> search(String name) {
		return goodsDao.search(name);
	}


	public GoodsEntity findOne(String id) {
		return goodsDao.findOne(Integer.valueOf(id));
	}

}
