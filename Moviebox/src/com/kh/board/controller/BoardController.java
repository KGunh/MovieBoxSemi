package com.kh.board.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;

public class BoardController {

	public String selectBoardList(HttpServletRequest request) {
		
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		int maxPage;
		int StartPage;
		int endPage;

		listCount = new BoardService().selectListCount();


		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		// null 나옴 ㅠㅠ NumberFormatException
		
		System.out.println(listCount);
		System.out.println(currentPage);
		
		ArrayList<Board> list = new BoardService().selectBoardList();
		request.setAttribute("boardList", list);
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
