package com.kh.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.vo.Member;

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
		String view = "";
		boolean flag = false;
		
		MemberAdminController MAC = new MemberAdminController();
		
		
		
		switch(mapping) {
		
		case "selectAdmin"   :  view = MAC.selectAdmin(request,response); break;
		case "modifyAdmin"   :  view = MAC.detailAdmin(request,response); break;
		case "revisedAdmin"  :  view = MAC.updateAdmin(request,response); flag=true; break;
		case "deleteAdmin"	 :  view = MAC.deleteAdmin(request,response); break;
		case "search"		 :  view = MAC.search(request,response); break;  
		
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
