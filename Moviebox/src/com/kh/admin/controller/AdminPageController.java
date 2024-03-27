package com.kh.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.model.service.AdminPageService;

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
		
		
		
		
		
		
		
		
		//---request.setAttribute로 두개 다 넣기
		
		//---view 주소 넣고 리턴
		
		
	}
	
	



	
	
	
	
	
	
	
	
	                         
	
	
	
	
	
	
}
