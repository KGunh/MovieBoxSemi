package com.kh.theater.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.theater.model.service.TheaterService;
import com.kh.theater.model.vo.Theater;

public class TheaterController {
	
	public String ListDetail(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Theater> list = new TheaterService().theaterAll();
		request.setAttribute("theaterList", list);
		
		String view = "views/theater/theaterDetail.jsp";
		
		return view;
	}
	
	public String selectTheaterDetail(HttpServletRequest request, HttpServletResponse response) {
		
		int theaterNo = Integer.parseInt(request.getParameter("theaterNo"));
		Theater theater = new TheaterService().selectTheaterDetail(theaterNo);
		
		request.setAttribute("theater", theater);
		
		String view = "views/theater/theaterDetail.jsp";
		
		return view;
	}


}
