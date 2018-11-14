package cn.sihai.soft.api.controller;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.sihai.soft.api.entity.GoodsTypeEntity;
import cn.sihai.soft.api.service.GoodsTypeService;
/**
 * 已失效
 * 用GoodsAllTypeController代替
 * 创建人：Jarvan   
 * 创建时间：2018年11月14日 上午11:20:25
 */
@RestController
@RequestMapping("${basepath}/goodsType")
public class GoodsTypeController {
	
	public static Logger logger = LogManager.getLogger(GoodsTypeController.class);
	
	@Autowired
	private GoodsTypeService goodsTypeService;
	
	
	/**
	 * 取得所有一级目录
	 * @return
	 */
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	public ArrayList<GoodsTypeEntity> getAll(){
		
		ArrayList<GoodsTypeEntity> ret = goodsTypeService.findAll();
		return ret;
	}
	
	
	/**
	 * 根据id获取对象
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/getOne", method = RequestMethod.GET)
	public GoodsTypeEntity getOne(@RequestParam String id){
		
		GoodsTypeEntity entity = goodsTypeService.findOne(id);
		return entity;
	}
	

}
