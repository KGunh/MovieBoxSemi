package com.kh.board.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;

public class BoardController {

	public String selectBoardList(HttpServletRequest request) {
		
		ArrayList<Board> list = new BoardService().selectBoardList();
		request.setAttribute("boardList", list);
		String view = "views/board/BoardList.jsp";
		
		return view;
	}
	
	public String detailBoard(HttpServletRequest request, HttpServletResponse response) {
		
		int boardNo = new BoardService().detailBoard(boardNo);
		
		Board board = new BoardService().detailBoard(boardNo);
		request.setAttribute("board", board);
		
		String view = "views/board/boardDetail.jsp";
		
		return view;
		
	}

}
