package cn.sihai.soft.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.sihai.soft.api.entity.GoodsAllTypeEntity;
import cn.sihai.soft.api.service.GoodsAllTypeService;

@RestController
@RequestMapping("${basepath}/goodsAllType")
public class GoodsAllTypeController {
	
	@Autowired
	private GoodsAllTypeService goodsAllTypeService;
	
	
	/**
	 * 根据id获取对象
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/getOne", method = RequestMethod.GET)
	public GoodsAllTypeEntity getOne(@RequestParam String id){
		
		GoodsAllTypeEntity entity = goodsAllTypeService.findOne(id);
		return entity;
	}
	
	/**
	 * 取得所有一级目录
	 * @return
	 */
	@RequestMapping(value="/getFirst", method = RequestMethod.GET)
	public ArrayList<GoodsAllTypeEntity> getFirst(){
		
		ArrayList<GoodsAllTypeEntity> ret = goodsAllTypeService.getFirst();
		return ret;
	}
	
	
	/**
	 * 根据一级目录id获取对应的二级目录
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/getSecond", method = RequestMethod.GET)
	public ArrayList<GoodsAllTypeEntity> getSecond(@RequestParam String pid){
		
		ArrayList<GoodsAllTypeEntity> ret = goodsAllTypeService.getSecond(pid);
		
		return ret;
	}
	
	
	/**
	 * name模糊查询
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/search", method = RequestMethod.GET)
	public ArrayList<GoodsAllTypeEntity> search(@RequestParam String name){
		
		ArrayList<GoodsAllTypeEntity> ret = goodsAllTypeService.search(name);
		
		return ret;
	}

}
