package cn.sihai.soft.api.entity;

import com.alibaba.fastjson.JSONArray;

public class ReturnGoodsEntity {
	private Integer id;
	
	private JSONArray goodsImgs;
	
	private String goodsIndexImg;
	
	private String goodsIntroduce;
	
	private JSONArray goodsIntroduceImgs;
	
	private String goodsName;
	
	private JSONArray goodsPrice;
	
	private JSONArray goodsRealImgs;
	
	private String goodsSecondTypeId;
	
	private JSONArray goodsSpec;
	
	private String goodsUnit;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public JSONArray getGoodsImgs() {
		return goodsImgs;
	}

	public void setGoodsImgs(JSONArray goodsImgs) {
		this.goodsImgs = goodsImgs;
	}

	public String getGoodsIndexImg() {
		return goodsIndexImg;
	}

	public void setGoodsIndexImg(String goodsIndexImg) {
		this.goodsIndexImg = goodsIndexImg;
	}

	public String getGoodsIntroduce() {
		return goodsIntroduce;
	}

	public void setGoodsIntroduce(String goodsIntroduce) {
		this.goodsIntroduce = goodsIntroduce;
	}

	public JSONArray getGoodsIntroduceImgs() {
		return goodsIntroduceImgs;
	}

	public void setGoodsIntroduceImgs(JSONArray goodsIntroduceImgs) {
		this.goodsIntroduceImgs = goodsIntroduceImgs;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public JSONArray getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(JSONArray goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public JSONArray getGoodsRealImgs() {
		return goodsRealImgs;
	}

	public void setGoodsRealImgs(JSONArray goodsRealImgs) {
		this.goodsRealImgs = goodsRealImgs;
	}

	public String getGoodsSecondTypeId() {
		return goodsSecondTypeId;
	}

	public void setGoodsSecondTypeId(String goodsSecondTypeId) {
		this.goodsSecondTypeId = goodsSecondTypeId;
	}

	public JSONArray getGoodsSpec() {
		return goodsSpec;
	}

	public void setGoodsSpec(JSONArray goodsSpec) {
		this.goodsSpec = goodsSpec;
	}

	public String getGoodsUnit() {
		return goodsUnit;
	}

	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit;
	}
	
}
