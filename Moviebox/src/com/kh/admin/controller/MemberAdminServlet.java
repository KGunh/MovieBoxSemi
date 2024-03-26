package com.kh.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberAdminController
 */
@WebServlet("*.mb")
public class MemberAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberAdminServlet() {
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
		boolean flag = false;
		
		MemberAdminController MAC = new MemberAdminController();
		
		
		
		switch(mapping) {
		
		case "selectAdmin"    :  view = "views/admin/memberSelect.jsp"; break;
		case "modifyAdmin."   :  view= "views/admin/memberModify.jsp"; break;
		
		}
		
		System.out.println(view);
		

		
		
		switch(mapping) {
		
		case "selectAdmin" :  MAC.selectAdmin(request);  break; 
		case "editAdmin"   :  view=MAC.editAdmin(request); break; 
		
		}
		
		
		if(false!=flag) {
			response.sendRedirect(view);
		}else {
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
