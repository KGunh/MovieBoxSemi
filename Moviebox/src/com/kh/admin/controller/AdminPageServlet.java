package com.kh.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.controller.MemberController;

/**
 * Servlet implementation class AdminPageController
 */
@WebServlet("*.admin")
public class AdminPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// uri담기
		String uri = request.getRequestURI();
		String mapping = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		
		// 변수선언
		AdminPageController admin = new AdminPageController();
		
		String view = "";
		boolean flag = true;
	
		switch(mapping) {
//		case "adminMovieCheck" :
//			view = "/views/admin/adminMovieCheck.jsp"; break; //영화목록
		
		case "adminMovieCheck" :
			view = admin.adminSelectMovieList(request); flag = false; break; //영화목록전체
			
		case "adminMovieInsert" :
			view = "/views/admin/adminMovieInsert.jsp"; break; //영화등록


			
			
//		case "adminBoardCheck" :
//			view = "/views/admin/adminBoardCheck.jsp"; break; //공지목록
			
		case "adminBoardCheck" :
			view = admin.adminSelectNoticeList(request); flag = false; break; //공지목록전체
			
		case "adminBoardInsert" :
			view = "/views/admin/adminBoardInsert.jsp"; break; //공지등록
			
			
		case "adminQnACheck" :
			view = "/views/admin/adminQnACheck.jsp"; break; //문의목록
			
		case "adminQnAInsert" :
			view = "/views/admin/adminQnAInsert.jsp"; break; //문의관리
			
		
			
			
			
			
		}

	
		if (flag) {
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
