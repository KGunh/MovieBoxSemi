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

/**
 * Servlet implementation class TheaterNameSearchController
 */
@WebServlet("/search.theatername")
public class TheaterNameSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TheaterNameSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String theaterName = request.getParameter("theaterName");
		ArrayList<Theater> list = new TheaterService().searchTheaterName(theaterName);
		String type = request.getParameter("type");
		
		request.setAttribute("type", type);
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/theater/searchTheater.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
