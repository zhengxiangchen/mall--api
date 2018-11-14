package cn.sihai.soft.api.test;


import com.alibaba.fastjson.JSONArray;


public class Test {

	public static void main(String[] args) {
		
		JSONArray goodsImgs = new JSONArray();
		goodsImgs.add("http://192.168.1.205:8080/goods/海产品/鱿鱼系列/手撕鱿鱼/1.jpg");
		goodsImgs.add("http://192.168.1.205:8080/goods/海产品/鱿鱼系列/手撕鱿鱼/2.jpg");
		
		JSONArray goodsIntroduceImgs = new JSONArray();
		goodsIntroduceImgs.add("http://192.168.1.205:8080/goods/海产品/鱿鱼系列/手撕鱿鱼/详情1.jpg");
		goodsIntroduceImgs.add("http://192.168.1.205:8080/goods/海产品/鱿鱼系列/手撕鱿鱼/详情2.jpg");
		
		JSONArray goodsPrice = new JSONArray();
		goodsPrice.add("30");
		goodsPrice.add("55");
		
		JSONArray goodsRealImgs = new JSONArray();
		goodsRealImgs.add("http://192.168.1.205:8080/goods/海产品/鱿鱼系列/手撕鱿鱼/实拍1.jpg");
		goodsRealImgs.add("http://192.168.1.205:8080/goods/海产品/鱿鱼系列/手撕鱿鱼/实拍2.jpg");
		
		JSONArray goodsSpec = new JSONArray();
		goodsSpec.add("70克");
		goodsSpec.add("155克");
		
		System.out.println(goodsImgs);
		System.out.println(goodsIntroduceImgs);
		System.out.println(goodsPrice);
		System.out.println(goodsRealImgs);
		System.out.println(goodsSpec);
		
		
	}

}
