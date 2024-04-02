package com.kh.theater.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.theater.model.service.TheaterService;
import com.kh.theater.model.vo.Theater;

public class TheaterController {
	
	public String selectTheaterDetail(HttpServletRequest request, HttpServletResponse response) {
		
		int tNo = Integer.parseInt(request.getParameter("theaterNo"));
		Theater theater = new TheaterService().detailTheater(tNo);
		request.setAttribute("theater", theater);
		
		String view = "views/theater/theaterDetail.jsp";
		
		return view;
		
	}

}
