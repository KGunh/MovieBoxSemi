package com.kh.admin.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.model.service.MemberAdminService;
import com.kh.common.model.vo.Location;
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
	
	
	public String category(HttpServletRequest request, HttpServletResponse response) {
		
		String view ="/views/admin/CinemaInsert.jsp"; 
		
		ArrayList<Location> location =  new MemberAdminService().category();
		System.out.println(location);
		
		request.setAttribute("location", location);
		
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
		
		String name = request.getParameter("cinemaname");
		String code = request.getParameter("address");
		String region = request.getParameter("region");
		String link = request.getParameter("link");
		
		
	
		
		theater.setTheaterName(name);
		theater.setTheaterAddr(code);
		theater.setLocationName(region);
		theater.setMapLink(link);

		new MemberAdminService().cinemaInsert(theater);
		
		return view;
		
	}
	
	
}
