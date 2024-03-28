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
	
	public String detailQna(HttpServletRequest request, HttpServletResponse response) {
		

		
		
	}

}
