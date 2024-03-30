package com.kh.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QnaServlet
 */
@WebServlet("*.board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// 변수 선언 
		
		BoardController bc = new BoardController();
		
		// URI 담기
		String uri = request.getRequestURI();
		String mapping = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		
		String view = "";
		boolean flag = true;
		
		switch(mapping) {
		case "list" : view = bc.selectBoardList(request, response); flag= false; break; // dispatcher
		case "detail" : view = bc.detailBoard(request, response); flag= false; break;
		case "insert" : view = bc.insertBoard(request, response); flag= false; break;
		case "enrollForm" : view = bc.selectCategoryList(request, response); flag= false; break;
		// 수정 페이지에서 등록 누를 시 연결되는 페이지
		case "update" : view = bc.updateBoard(request, response); flag= false; break;
		// 디테일 페이지에서 수정 누를 시 연결되는 페이지
		case "updateForm" : view = bc.updateBoardForm(request, response); flag= false; break;
		case "delete" : view = bc.deleteBoard(request, response); flag= false; break;
		}
		
		
		if(flag) {
			response.sendRedirect(request.getContextPath() + view);
		} else {
			request.getRequestDispatcher(view).forward(request, response);
		}
		
		
		
		
		
		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
