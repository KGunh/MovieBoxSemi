package com.kh.admin.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.kh.admin.model.service.AdminPageService;
import com.kh.board.model.vo.Board;
import com.kh.common.model.vo.PageInfo;
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
	
	
	// 문의 목록 전체 출력
	public String adminSelectQnAList(HttpServletRequest request) {
		ArrayList<Board> list = new AdminPageService().adminSelectQnAList();
		request.setAttribute("adminQnACheck", list);
		String view = "views/admin/adminQnACheck.jsp";
		
		return view;
	}



	//페이징바.....................
	public String paging(HttpServletRequest request) {
		
		//필요한 변수들
		int listCount; // 현재 일반게시판의 게시글 총 개수 => BOARD테이블로부터 COUNT(*)활용해서 조회
		int currentPage; // 현재 페이지(사용자가 요청한 페이지) => request.getParameter("currentPage")
		int pageLimit; // 페이지 하단에 보여질 페이징바의 최대 개수 => 10개로 고정
		int boardLimit; // 한 페이지에 보여질 게시글의 최대 개수 => 10개로 고정
		
		int maxPage; // 가장 마지막 페이지가 몇 번 페이지인지(총 페이지의 개수)
		int startPage; // 페이지 하단에 보여질 페이징바의 시작 수
		int endPage; // 페이지 하단에 보여질 페이징바의 끝 수
		
		//listCount : 총 게시글의 수
		listCount = new AdminPageService().selectListCount();
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		pageLimit = 10;
		boardLimit = 10; 
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Movie> movieList = new AdminPageService().selectList(pi);
		
	
	
	
	}
	
	
	 
	
	
	
	
	                         
	
	
	
	
	
	
}
