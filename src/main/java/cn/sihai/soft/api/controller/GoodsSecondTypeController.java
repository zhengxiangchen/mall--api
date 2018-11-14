package cn.sihai.soft.api.controller;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.sihai.soft.api.entity.GoodsSecondTypeEntity;
import cn.sihai.soft.api.service.GoodsSecondTypeService;

/**
 * 已失效
 * 用GoodsAllTypeController代替
 * 创建人：Jarvan   
 * 创建时间：2018年11月14日 上午11:20:25
 */
@RestController
@RequestMapping("${basepath}/goodsSecondType")
public class GoodsSecondTypeController {
	
public static Logger logger = LogManager.getLogger(GoodsSecondTypeController.class);
	
	
	@Autowired
	private GoodsSecondTypeService goodsSecondTypeService;
	
	
	/**
	 * name模糊查询
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/search", method = RequestMethod.GET)
	public ArrayList<GoodsSecondTypeEntity> search(@RequestParam String name){
		
		ArrayList<GoodsSecondTypeEntity> ret = goodsSecondTypeService.search(name);
		
		return ret;
	}
	
	
	/**
	 * 根据id获取对象
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/getOne", method = RequestMethod.GET)
	public GoodsSecondTypeEntity getOne(@RequestParam String id){
		
		GoodsSecondTypeEntity entity = goodsSecondTypeService.findOne(id);
		return entity;
	}
	
	
	
	/**
	 * 根据一级目录id获取对应的二级目录
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/getTypeByFirstType", method = RequestMethod.GET)
	public ArrayList<GoodsSecondTypeEntity> getTypeByFirstType(@RequestParam String firstTypeId){
		
		ArrayList<GoodsSecondTypeEntity> ret = goodsSecondTypeService.findByFirstType(firstTypeId);
		
		return ret;
	}

}
