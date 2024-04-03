package com.kh.goods.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kh.goods.model.service.GoodsService;
import com.kh.goods.model.vo.Goods;

public class GoodsController {

	public String selectGoodsList(HttpServletRequest request) {
		
		List<Goods> goodsList = new GoodsService().selectGoodsList();
		
		request.setAttribute("goodsList", goodsList);
		
		return "views/goods/goodsList.jsp";
	}
	
}
