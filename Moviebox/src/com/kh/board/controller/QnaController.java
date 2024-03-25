package com.kh.board.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.kh.board.model.service.QnaService;
import com.kh.board.model.vo.Board;

public class QnaController {

	public String selectQnaList(HttpServletRequest request) {
		
		ArrayList<Board> list = new QnaService().selectQnaList();
		request.setAttribute("qnaList", list);
		String view = "views/board/qnaList.jsp";
		
		return view;
	}

}
