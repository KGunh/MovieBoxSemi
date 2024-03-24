package com.kh.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeServlet
 */
@WebServlet("*.notice")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// 변수 선언 
		
		NoticeController nc = new NoticeController();
		
		// URI 담기
		String uri = request.getRequestURI();
		
		String view = "";
		boolean flag = true;
		
		String mapping = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		
		switch(mapping) {
		case "list" : view = "views/notice/noticeList.jsp"; break;
		}
		
		if(flag) {
			response.sendRedirect(view);
		} else {
			
			//ArrayList<Notice> noticeList = new NoticeService().selectNoticeList();
			//request.setAttribute("noticeList", noticeList);
			
			request.getRequestDispatcher(view).forward(request, response);
		}
		
		
		// 공지사항 목록 출력

		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
