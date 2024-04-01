package com.kh.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CinemaController
 */
@WebServlet("*.cm")
public class CinemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CinemaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String uri =request.getRequestURI();
		String mapping = uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));
		System.out.println(mapping);
		String view = "";
		
		CinemaAdminContorller CAC = new CinemaAdminContorller();
		
		boolean flag = false;
		
		switch(mapping) {
		
		case "insertAdmin" :  view = CAC.category(request, response); break;
		case "editAdmin"   :  view= CAC.cinemaEdit(request,response); break;
		case "checkAdmin"  :  view = CAC.cinemaCheck(request,response); break;
		case "enroll" 	   :  view = CAC.cinemaInsert(request, response); break;
		//case ""			   :  view = CAC.cinemaInsert(request,response);
		
		}
		
		if(false != flag) {
			response.sendRedirect(view);
			
		}else {
			System.out.println(view);
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
