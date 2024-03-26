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
		
		case "insertAdmin" :  view = "/views/admin/CinemaInsert.jsp";
		case "editAdmin"   :  view= "/views/admin/CinemaEdit.jsp";
		case "checkAdmin"  :  view = "views/admin/CinemaCheck.jsp";
		
		}
		
		if(false != flag) {
		response.sendRedirect(view);
			
		}else {
			System.out.println(view);
			request.getRequestDispatcher(view).forward(request, response);	
		}
		
		switch(mapping) {
		
		case "insertAdmin" :  CAC.cinemaInsert();
		case "editAdmin"   :  CAC.cinemaEdit();
		case "checkAdmin"  :  CAC.cinemaCheck();
		
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
