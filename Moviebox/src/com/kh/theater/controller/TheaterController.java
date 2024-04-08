package com.kh.theater.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.vo.Attachment;
import com.kh.movie.model.vo.Movie;
import com.kh.theater.model.service.TheaterService;
import com.kh.theater.model.vo.Theater;

public class TheaterController {
	
	// 영화관 상세
	public String listDetail(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Theater> list = new TheaterService().theaterAll();
		request.setAttribute("theaterList", list);
		String view = "views/theater/theaterDetail.jsp";
		return view;
	}
	
	public String selectTheaterDetail(HttpServletRequest request, HttpServletResponse response){
		
		int theaterNo = Integer.parseInt(request.getParameter("theaterNo"));
		ArrayList<Theater> theater = new TheaterService().selectTheaterDetail(theaterNo);
		request.setAttribute("theater", theater);
		
		String view = "views/theater/theaterDetail.jsp";
		
		return view;
	}

	// 포스터
	public String theaterImg(HttpServletRequest request, HttpServletResponse response){
		int movieNo = Integer.parseInt(request.getParameter("movieNo"));
		ArrayList<Attachment> attachment = new TheaterService().theaterImg(movieNo);
		request.setAttribute("attachment", attachment);
		
		String view = "views/theater/theaterDetail.jsp";
		
		return view;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
