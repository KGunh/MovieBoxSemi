package com.kh.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.admin.model.service.AdminPageService;
import com.kh.movie.model.service.MovieService;
import com.kh.movie.model.vo.Movie;
import com.kh.theater.model.vo.Screen;

/**
 * Servlet implementation class AjaxAdminSelectDate
 */
@WebServlet("/selectDate.admin")
public class AjaxAdminSelectDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxAdminSelectDate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		int theaterNo = Integer.parseInt(request.getParameter("theaterNo"));
		String watchDate = request.getParameter("watchDate");
		
		
		
		
		Screen sc = new Screen();
		sc.setTheaterNo(theaterNo);
		sc.setWatchDate(watchDate);
		List<Movie> movieNameList = new MovieService().selectMovieList();
		
		List<Screen> list = new AdminPageService().adminDetailTheater(sc);
		for(int i = 0; i<list.size();i++) {
			list.get(i).setMovieNameList(movieNameList);
		}
		
		response.setContentType("application/json; charset=UTF-8");
				
		new Gson().toJson(list, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
