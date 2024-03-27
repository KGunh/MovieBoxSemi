package com.kh.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.model.service.AdminPageService;
import com.kh.common.model.vo.PageInfo;

public class AdminPageController {
	
	
	
	public void adminMovieCheck(HttpServletRequest request, HttpServletResponse response){
		//---게시글 리스트 가져오기
		
		
		//---페이징처리변수만들기
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new AdminPageService().selectListCount();
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		pageLimit = 10; //페이징바개수
		boardLimit = 10; //게시글개수
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		
		
		
		//VO로 가공
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit,
				   maxPage, startPage, endPage);
		//---request.setAttribute로 두개 다 넣기
		
		//---view 주소 넣고 리턴
		
		
	}
	
	



	
	
	
	
	
	
	
	
	                         
	
	
	
	
	
	
}
