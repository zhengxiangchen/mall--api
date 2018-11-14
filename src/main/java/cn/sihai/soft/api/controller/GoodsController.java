package cn.sihai.soft.api.controller;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;

import cn.sihai.soft.api.entity.GoodsEntity;
import cn.sihai.soft.api.entity.ReturnGoodsEntity;
import cn.sihai.soft.api.service.GoodsService;

@RestController
@RequestMapping("${basepath}/goods")
public class GoodsController {
	
	public static Logger logger = LogManager.getLogger(GoodsController.class);
	
	
	@Autowired
	private GoodsService goodsService;
	
	/**
	 * name模糊查询
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/search", method = RequestMethod.GET)
	public ArrayList<GoodsEntity> search(@RequestParam String name){
		
		ArrayList<GoodsEntity> ret = goodsService.search(name);
		
		return ret;
	}
	
	
	/**
	 * 根据id获取对象
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/findOne", method = RequestMethod.GET)
	public ReturnGoodsEntity findOne(@RequestParam String id){
		ReturnGoodsEntity entity = new ReturnGoodsEntity();
		GoodsEntity goods = goodsService.findOne(id);
		
		entity.setId(goods.getId());
		entity.setGoodsIndexImg(goods.getGoodsIndexImg());
		entity.setGoodsIntroduce(goods.getGoodsIntroduce());
		entity.setGoodsName(goods.getGoodsName());
		entity.setGoodsSecondTypeId(goods.getGoodsSecondTypeId());
		entity.setGoodsUnit(goods.getGoodsUnit());
		
		entity.setGoodsImgs(JSONArray.parseArray(goods.getGoodsImgs()));
		entity.setGoodsIntroduceImgs(JSONArray.parseArray(goods.getGoodsIntroduceImgs()));
		entity.setGoodsPrice(JSONArray.parseArray(goods.getGoodsPrice()));
		entity.setGoodsRealImgs(JSONArray.parseArray(goods.getGoodsRealImgs()));
		entity.setGoodsSpec(JSONArray.parseArray(goods.getGoodsSpec()));
		return entity;
	}
	
	
	/**
	 * 获取首页显示的商品列表
	 * @return
	 */
	@RequestMapping(value="/getIndexList", method = RequestMethod.GET)
	public ArrayList<ReturnGoodsEntity> getIndexList(@RequestParam Integer num){
		ArrayList<ReturnGoodsEntity> ret = new ArrayList<ReturnGoodsEntity>();
		
		ArrayList<GoodsEntity> goodsList = goodsService.getIndexList(num);
		for(int i = 0; i < goodsList.size(); i++){
			ReturnGoodsEntity entity = new ReturnGoodsEntity();
			GoodsEntity goods = goodsList.get(i);
			entity.setId(goods.getId());
			entity.setGoodsIndexImg(goods.getGoodsIndexImg());
			entity.setGoodsIntroduce(goods.getGoodsIntroduce());
			entity.setGoodsName(goods.getGoodsName());
			entity.setGoodsSecondTypeId(goods.getGoodsSecondTypeId());
			entity.setGoodsUnit(goods.getGoodsUnit());
			
			entity.setGoodsImgs(JSONArray.parseArray(goods.getGoodsImgs()));
			entity.setGoodsIntroduceImgs(JSONArray.parseArray(goods.getGoodsIntroduceImgs()));
			entity.setGoodsPrice(JSONArray.parseArray(goods.getGoodsPrice()));
			entity.setGoodsRealImgs(JSONArray.parseArray(goods.getGoodsRealImgs()));
			entity.setGoodsSpec(JSONArray.parseArray(goods.getGoodsSpec()));
			
			ret.add(entity);
		}
		
		return ret;
	}
	
	
	/**
	 * 根据一级目录id获取对应的二级目录
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/getListBySecondTypeId", method = RequestMethod.GET)
	public ArrayList<ReturnGoodsEntity> getListBySecondTypeId(@RequestParam String goodsSecondTypeId){
		ArrayList<ReturnGoodsEntity> ret = new ArrayList<ReturnGoodsEntity>();
		
		ArrayList<GoodsEntity> goodsList = goodsService.findBySecondType(goodsSecondTypeId);
		for(int i = 0; i < goodsList.size(); i++){
			ReturnGoodsEntity entity = new ReturnGoodsEntity();
			GoodsEntity goods = goodsList.get(i);
			entity.setId(goods.getId());
			entity.setGoodsIndexImg(goods.getGoodsIndexImg());
			entity.setGoodsIntroduce(goods.getGoodsIntroduce());
			entity.setGoodsName(goods.getGoodsName());
			entity.setGoodsSecondTypeId(goods.getGoodsSecondTypeId());
			entity.setGoodsUnit(goods.getGoodsUnit());
			
			entity.setGoodsImgs(JSONArray.parseArray(goods.getGoodsImgs()));
			entity.setGoodsIntroduceImgs(JSONArray.parseArray(goods.getGoodsIntroduceImgs()));
			entity.setGoodsPrice(JSONArray.parseArray(goods.getGoodsPrice()));
			entity.setGoodsRealImgs(JSONArray.parseArray(goods.getGoodsRealImgs()));
			entity.setGoodsSpec(JSONArray.parseArray(goods.getGoodsSpec()));
			
			ret.add(entity);
		}
		return ret;
	}
	
	
	
	

}
