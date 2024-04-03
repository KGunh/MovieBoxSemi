package com.kh.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.admin.model.service.AdminPageService;
import com.kh.theater.model.vo.Screen;

/**
 * Servlet implementation class AjaxAdminInsertScreen
 */
@WebServlet("/insertScreen.admin")
public class AjaxAdminInsertScreen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxAdminInsertScreen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String screenName = request.getParameter("screenName");
		int movieNo = Integer.parseInt(request.getParameter("selectMovie"));
		String watchDate = request.getParameter("watchDate");
		String watchTime = request.getParameter("watchTime");
		int theaterNo = Integer.parseInt(request.getParameter("theaterNo"));
		String insertDate = watchDate + "/" + watchTime;
		System.out.println(insertDate);
		Screen sc = new Screen();
		sc.setMovieNo(movieNo);
		sc.setTheaterNo(theaterNo);
		sc.setScreenName(screenName);
		sc.setWatchDate(insertDate);
		
		int result = new AdminPageService().insertScreen(sc);
		
		response.setContentType("application/json; charset=UTF-8");
		
		new Gson().toJson(result, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
