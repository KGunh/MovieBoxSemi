package com.kh.goods.controller;

import javax.servlet.http.HttpServletRequest;

import com.kh.goods.model.service.GoodsService;

public class GoodsController {

	public String selectGoodsList(HttpServletRequest request) {
		
		new GoodsService().selectGoodsList();
		
		return "views/goods/goodsList.jsp";
	}
	
}
