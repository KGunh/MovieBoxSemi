package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String mapping = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		
		String view = "";
		boolean flag = true;
		
		switch(mapping) {
		case "list" : view = nc.selectNoticeList(request); flag = false; break;
		case "insert" : view = nc.insertNotice(request, response); flag=false; break;
		case "enrollForm" : view = nc.selectCategoryList(request, response); flag = false; break;
		case "insertForm" : view = nc.insertFormNotice(request, response); flag = false; break;
		case "detail" : view = nc.detailNotice(request, response); flag = false; break;
		case "update" : view = nc.updateNotice(request, response); break;
		case "updateForm" : view = nc.updateNoticeList(request, response); flag = false; break;
		case "delete" : view = nc.deleteNotice(request, response); flag=false; break;
		case "search" : view = nc.searchNotice(request, response); flag = false; break;
		

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
