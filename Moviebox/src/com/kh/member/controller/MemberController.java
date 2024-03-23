package com.kh.member.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.common.model.vo.Genre;
import com.kh.common.model.vo.Reservation;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

public class MemberController {

	public String login(HttpServletRequest request, HttpServletResponse response) {
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		
		Member m = new Member();
		
		m.setMemberId(memberId);
		m.setMemberPwd(memberPwd);
		
		

		Member loginUser = new MemberService().login(m);
		String view = "";
		if(loginUser != null) {
			HttpSession session = request.getSession();
			
			session.setAttribute("loginUser", loginUser);
			
			session.setAttribute("alertMsg", "로그인 성공");
			
		} else {
			request.setAttribute("errorMsg", "로그인에 실패했습니다!");
			
			view = "views/common/errorPage.jsp";
		}
		
		
		return view;
	}
	
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		String view = "index.jsp";
		
		return view;
	}
	
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String memberName = request.getParameter("memberName");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		String phone = request.getParameter("phone");
		String localCode = request.getParameter("localCode");
		String address = request.getParameter("address");
		String[] genres = request.getParameterValues("genre");
		
		Member m = new Member();
		String view = "";
		
		ArrayList<Genre> genreList = new ArrayList();
		
		for(int i = 0;i< genres.length; i++) {
			Genre g = new Genre();
			g.setGenreName(genres[i]);
			genreList.add(g);
		}
		
		
	
		m.setMemberId(memberId);
		m.setMemberPwd(memberPwd);
		m.setMemberName(memberName);
		m.setBirthday(birthday);
		m.setGender(gender);
		m.setEmail(email);
		m.setPhone(phone);
		m.setLocalCode(localCode);
		m.setAddress(address);
		
		
		
		
		int result = new MemberService().insert(m,genreList);
		
		
		if(result > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "회원가입에 성공했습니다.");
		}else {
			request.setAttribute("errorMsg", "회원가입에 실패했습니다.");
			view = "views/common/errorPage.jsp";
		}
		
		return view;
	}
	
	public String myPagePrint(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		HttpSession session = request.getSession();
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		List<Reservation> list = new MemberService().myPagePrint(loginUser);
		
		
		
		
		
		
		
		
		return view;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
