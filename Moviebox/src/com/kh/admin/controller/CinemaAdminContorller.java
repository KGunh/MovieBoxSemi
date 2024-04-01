package com.kh.admin.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.model.service.MemberAdminService;
import com.kh.theater.model.vo.Theater;

public class CinemaAdminContorller {

	public String cinemaCheck (HttpServletRequest request, HttpServletResponse response) {
				
		
		
		String view = "views/admin/CinemaCheck.jsp";
		
		ArrayList<Theater> theater = new MemberAdminService().cinemaCheck();
		
		
		
		request.setAttribute("theater", theater);
		
		return view; 
		
	}
	
	public String cinemaEdit(HttpServletRequest request, HttpServletResponse response) {
		
		String view = "/views/admin/CinemaEdit.jsp";
		
		return view;
		
	}
	
	public String cinemaInsert(HttpServletRequest request, HttpServletResponse response) {
		
		
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		Theater theater = new Theater();
		String view = "/views/admin/CinemaInsert.jsp";
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String region = request.getParameter("region");
		String link = request.getParameter("link");
		
		
		switch(region) {
		
		case "서울" : String 서울;
		case "경기" : String 경기;
		case "인천" : String 인천;
		case "강원" : String 강원;
		case "충남" : String 충남;
		case "충북" : String 충북;
		case "대구" : String 대구;
		case "경북" : String 경북;  
		case "울산" : String 울산;
		case "부산" : String 부산;
		case "경남" : String 경남;
		case "제주" : String 제주;
		
		
		
		}
		
		theater.setTheaterName(name);
		theater.setTheaterAddr(address);
		theater.setLocationName(region);
		theater.setMapLink(link);

		new MemberAdminService().cinemaInsert(theater);
		
		return view; 
		
	}
	
	
}
