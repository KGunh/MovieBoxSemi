package com.kh.board.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Category;
import com.kh.common.model.vo.PageInfo;
import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

public class BoardController {

	public String selectBoardList(HttpServletRequest request, HttpServletResponse response) {
		
		// 페이징바 
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		int maxPage;
		int startPage;
		int endPage;

		listCount = new BoardService().selectListCount();


		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		pageLimit = 5;
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		// 5 => 1, 6, 11, 16 ... n * 5(페이징단위) + 1 
		//			 startPage = n * pageLimit  + 1;
		// n = (currentPage - 1) / pageLimit
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
//		System.out.println(pi);
		
		ArrayList<Board> list = new BoardService().selectBoardList(pi);
		
		
		// 전체 목록 출력
//		ArrayList<Board> list = new BoardService().selectBoardList();
		request.setAttribute("boardList", list);
		request.setAttribute("pageInfo", pi);

		String view = "views/board/boardList.jsp";
		
		return view;
	}
	
	
	
	
	
//	
//	public String detailBoard(HttpServletRequest request, HttpServletResponse response) {
//		
//		int boardNo = new BoardService().detailBoard(boardNo);
//		
//		Board board = new BoardService().detailBoard(boardNo);
//		request.setAttribute("board", board);
//		
//		String view = "views/board/boardDetail.jsp";
//		
//		return view;
//		
//	}

}
