package com.kh.admin.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import com.kh.admin.model.service.MemberAdminService;
import com.kh.common.JDBCTemplate;
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
		
		int theaterNo = Integer.parseInt(request.getParameter("theaterNo"));
		
		Theater theater = new MemberAdminService().cinemaEdit(theaterNo);
		String view = "/views/admin/CinemaEdit.jsp";
		
		return view;
		
	}
	
	
	public String category(HttpServletRequest request, HttpServletResponse response) {
		
		String view ="/views/admin/CinemaInsert.jsp"; 
		
		ArrayList<Location> location =  new MemberAdminService().category();

		
		HttpSession session = request.getSession();
		session.setAttribute("location", location);
		
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
		System.out.println(name);
		String code = request.getParameter("address");
		String region = request.getParameter("region");
		String link = request.getParameter("link");
		
		
	
		
		theater.setTheaterName(name);
		theater.setTheaterAddr(code);
		theater.setLocalCode(region);
		theater.setMapLink(link);

		int result = new MemberAdminService().cinemaInsert(theater);
	
		if(result>0) {
		
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "영화관 정보가 등록되었습니다.");
			
			return view;
			
		}else {
			request.setAttribute("errorMsg", "영화관 정보 등록 실패하였습니다.");
		}
		
		
		
		
		return view;
		
	}
	
	public String modifyCinema(HttpServletRequest request, HttpServletResponse response) {
		
		int theaterNo = Integer.parseInt(request.getParameter("theaterNo"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String link = request.getParameter("link");
		String code = request.getParameter("code");
		String enrollDate = request.getParameter("updateDate");
		
		Theater theater = new Theater();
		
		theater.setTheaterName(name);
		theater.setTheaterAddr(address);
		theater.setMapLink(link);
		theater.setLocalCode(code);
		theater.setUpdateDate(enrollDate);
		theater.setTheaterNo(theaterNo);
		
		int result = new MemberAdminService().modifyCinema(theater);
		
		if(result > 0) {
			HttpSession session = request.getSession();
			request.setAttribute("theater", theater);
			session.setAttribute("alertMsg", "정보수정이 완료되었습니다");
			
		}else {
			request.setAttribute("errorMsg", "영화관 정보 등록 실패하였습니다.");
		}
		
		
		String view = request.getContextPath()+"/editAdmin.cm?theaterNo=" + theaterNo;
		
		
		
		return view;
	}
	
	public String deleleteCinema(HttpServletRequest request, HttpServletResponse response) {
		
		int theaterNo = Integer.parseInt(request.getParameter("theaterNo"));
		int result = new MemberAdminService().deleleteCinema(theaterNo);
		
		
		if(result>0) {
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "삭제되었습니다");
		} else {
			request.setAttribute("errorMsg", "삭제되지 않았습니다");
		}
		
		String view ="views/admin/CinemaCheck.jsp";
		
		return view; 
		
	}
	
	public String searchCinema(HttpServletRequest request, HttpServletResponse response) {
		
		String category = request.getParameter("category");
		String search = request.getParameter("find");
		String view = "views/admin/CinemaSearch.jsp";
		
		switch(category) {
		case "name" : category = "THEATER_NAME"; break;
		case "code" : category = "LOCATION_CODE"; break;
		case "city" : category = "LOCATION_NAME"; 
	
		
	
		}
		
		
		ArrayList<Theater> theater = new MemberAdminService().searchCinema(category,search);
		request.setAttribute("theaterlist", theater);
		
		
		
		
		
	
		return view;
}
	
}
