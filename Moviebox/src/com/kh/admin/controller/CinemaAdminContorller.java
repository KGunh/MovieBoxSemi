package com.kh.admin.controller;

import javax.servlet.http.HttpServletRequest;

public class CinemaAdminContorller {

	public void cinemaCheck () {
				
		
		
		
	}
	
	public void cinemaEdit() {
		
	}
	
	public void cinemaInsert(HttpServletRequest request) {
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String region = request.getParameter("region");
		String city = request.getParameter("city");
		
		
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
		
		
		
		
	}
	
	
}
