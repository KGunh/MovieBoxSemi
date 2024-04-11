package com.kh.goods.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kh.common.model.vo.PageInfo;
import com.kh.goods.model.service.GoodsService;
import com.kh.goods.model.vo.Goods;

public class GoodsController {

	public String selectGoodsList(HttpServletRequest request) {
		// 시작부터 ajax로 전부 바꿔야함
		int listCount; // 현재 일반게시판의 게시글 총 개수 => BOARD테이블로부터 COUNT(*)활용해서 조회
		int currentPage; // 현재 페이지(사용자가 요청한 페이지)=> request.getParameter("currentPage")
		int pageLimit; // 페이지 하단에 보여질 페이징바의 최대 개수 => 10개로 고정
		int boardLimit; // 한페이지에 보여질 게시글의 최대 개수 => 10개로 고정
		
		int maxPage; // 가장 마지막 페이지가 몇 번 페이지인지(총 페이지의 개수)
		int startPage; // 페이지 하단에 보여질 페이징바의 시작 수
		int endPage; // 페이지 하단에 보여질 페이징바의 끝 수
		
		listCount = new GoodsService().selectListCount();
		
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		pageLimit = 10;
		boardLimit = 10;
		maxPage = (int)(Math.ceil((double)listCount / boardLimit));
		startPage = ((currentPage - 1) / pageLimit) * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		List<Goods> goodsList = new GoodsService().selectGoodsList(pi);
		
		request.setAttribute("goodsList", goodsList);
		request.setAttribute("pageInfo", pi);
		
		return "views/goods/goodsList.jsp";
	}
	
}
