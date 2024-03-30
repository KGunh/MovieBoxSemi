package com.kh.admin.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.model.service.AdminPageService;
import com.kh.board.model.vo.Board;
import com.kh.common.model.vo.PageInfo;
import com.kh.movie.model.vo.Movie;
import com.kh.notice.model.vo.Notice;

public class AdminPageController {
	
	public String adminSelectMovieList(HttpServletRequest request, HttpServletResponse response) {
		
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		int maxPage;
		int startPage;
		int endPage;
		
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
		
		
		//vo가공
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit,
				   maxPage, startPage, endPage);

		//서비스호출
		ArrayList<Movie> list = new AdminPageService().adminSelectMovieList(pi);
		//응답화면지정
		request.setAttribute("adminMovieCheckList", list);
		request.setAttribute("pageInfo", pi);
		String view = "views/admin/adminMovieCheck.jsp";
	
		
		
		return view;
	}
	
	
	// 공지 목록 전체 출력
	public String adminBoardCheckList(HttpServletRequest request, HttpServletResponse response) {
		
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new AdminPageService().selectListCountNotice();
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		pageLimit = 10;
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);

		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit,
				   maxPage, startPage, endPage);
		
		ArrayList<Notice> list = new AdminPageService().adminSelectNoticeList(pi);
		request.setAttribute("adminBoardCheckList", list);
		request.setAttribute("pageInfo", pi);
		String view = "views/admin/adminBoardCheck.jsp";
		

		
		return view;
	}

	
	// 문의 목록 전체 출력
	public String adminSelectQnAList(HttpServletRequest request, HttpServletResponse response) {
		
		
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new AdminPageService().selectListCountQnA();
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		pageLimit = 10;
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);

		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit,
				   maxPage, startPage, endPage);
		
		//서비스호출
		ArrayList<Board> list = new AdminPageService().adminSelectQnAList(pi);
		//응답화면지정
		request.setAttribute("adminQnACheckList", list);
		request.setAttribute("pageInfo", pi);
		String view = "views/admin/adminQnACheck.jsp";
	
		

		
		return view;
	}




	
	
	
	
	                         
	
	
	
	
	
	
}
