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

		case "adminMovieCheck" :
			view = admin.adminSelectMovieList(request, response); flag = false; break; //영화목록전체
			
		case "adminMovieEnrollForm" :
			view = admin.adminMovieEnrollForm(request, response); flag = false; break; //영화등록양식페이지
			
		case "adminMovieInsert" :
			view = admin.adminMovieInsert(request, response); flag = false; break; //영화등록
			
		case "adminMovieUpdate" :
			view = admin.adminMovieUpdate(request, response); flag = false; break; //영화등록

		case "adminMovieDetail" :
			view = admin.adminMovieDetail(request, response); flag = false; break; //영화상세보기페이지
			
		case "adminMovieUpdateEnrollForm" :
		view = admin.adminMovieUpdateEnrollForm(request, response); flag = false; break; //영화수정
			
		case "adminMovieDelete" :
			view = admin.adminMovieDelete(request, response); flag = false; break; //영화삭제
		
			
			
		case "adminBoardCheck" :
			view = admin.adminBoardCheckList(request, response); flag = false; break; //공지목록전체
			
		case "adminBoardEnrollForm" :
			view = admin.adminBoardEnrollForm(request, response); flag = false; break; //공지등록양식페이지
			
		case "adminBoardInsert" :
			view = admin.adminBoardInsert(request, response); flag = false; break;
		
		case "adminBoardDetail" :
			view = admin.adminBoardDetail(request, response); flag = false; break; //공지상세보기

		case "adminBoardDelete" :
			view = admin.adminBoardDelete(request, response); flag = false; break; //공지삭제
			
			
		case "adminQnACheck" :
			view = admin.adminSelectQnAList(request, response); flag = false; break; //문의목록전체
			
		case "adminQnAInsert" :
			view = "/views/admin/adminQnAInsert.jsp"; break; //문의관리
		
		case "adminQnADetail" :
			view = admin.adminQnADetail(request, response); flag = false; break; //공지상세보기
			
		case "adminQnADelete" :
			view = admin.adminQnADelete(request, response); flag = false; break; //공지상세보기

			
			
			
			
			
			
			
			
			
			
		case "adminScreenList":
			view = "/views/admin/adminScreenList.jsp"; flag = false; break;
		case "adminDetailTheater":
			view =  admin.adminDetailTheater(request, response); flag = false; break;
			
			
		
			
			
			
			
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
