package cn.sihai.soft.api.controller;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.sihai.soft.api.entity.SwiperImgEntity;
import cn.sihai.soft.api.service.SwiperImgService;

@RestController
@RequestMapping("${basepath}/swiperImg")
public class SwiperImgController {
	public static Logger logger = LogManager.getLogger(SwiperImgController.class);
	
	@Autowired
	private SwiperImgService swiperImgService;
	
	
	/**
	 * 获取小程序首页的轮播图
	 * @return
	 */
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	public ArrayList<SwiperImgEntity> getAll(){
		return swiperImgService.getAll();
	}

}
