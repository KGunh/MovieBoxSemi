package com.kh.admin.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.kh.admin.model.service.AdminPageService;
import com.kh.movie.model.vo.Movie;
import com.kh.notice.model.vo.Notice;

public class AdminPageController {
	
	// 영화 목록 전체 출력
	public String adminSelectMovieList(HttpServletRequest request) {
		
		ArrayList<Movie> list = new AdminPageService().adminSelectMovieList();
		request.setAttribute("adminMovieCheck", list);
		String view = "views/admin/adminMovieCheck.jsp";
		
		return view;
		
	}
	
	
	
	// 공지 목록 전체 출력
	public String adminSelectNoticeList(HttpServletRequest request) {
		ArrayList<Notice> list = new AdminPageService().adminSelectNoticeList();
		request.setAttribute("adminBoardCheck", list);
		String view = "views/admin/adminBoardCheck.jsp";
		
		return view;
	}
	
	
	



	
	
	
	
	
	
	
	
	                         
	
	
	
	
	
	
}
