package com.kh.theater.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.theater.model.service.TheaterService;
import com.kh.theater.model.vo.Theater;

@WebServlet("/search.theater")
public class TheaterSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
     * @see HttpServlet#HttpServlet()
     */
    public TheaterSearchController() {
        super();
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Theater> list = new TheaterService().searchTheaterAll();

		String location = request.getParameter("location");
		String type = request.getParameter("type");
		
		//System.out.println(location);
		
		if(location != null) {
			if(!location.equals("전체")) {
				list = new TheaterService().selectTheaterLocation(location);
			}
		}
		
		request.setAttribute("location", location);
		request.setAttribute("type", type);
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/theater/searchTheater.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
