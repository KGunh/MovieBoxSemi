package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("*.me")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String uri = request.getRequestURI();


		String mapping = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));

		MemberController mc = new MemberController();

		String view = "";
		boolean flag = true;

		switch (mapping) {
		case "login":
			view = mc.login(request,response);
			if(!view.equals("views/common/errorPage.jsp")) {
				flag = false;
			}
			break;
		case "logout":
			view = mc.logout(request,response); flag = false; break;
		case "loginForm":
			view = "views/member/login.jsp"; flag = false; break;
		case "insertForm":
			view = "views/member/memberInsert.jsp"; flag = false; break;
		case "insert":
			view = mc.insert(request,response);
			if(!view.equals("views/common/errorPage.jsp")) {
				flag = false;
			}
			break;
		
		case "mypage":
			view = mc.myPagePrint(request, response);
			view = "views/member/myPage.jsp"; flag = false;
			break;
		default : return;
			
	
		}

		
		if (flag) {
			response.sendRedirect(request.getContextPath() + view);
		} else {
			request.getRequestDispatcher(view).forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
