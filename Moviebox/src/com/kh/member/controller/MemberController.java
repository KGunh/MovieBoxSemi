package com.kh.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.common.model.vo.Genre;
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
		String[] genreList = request.getParameterValues("genre");
		
		Member m = new Member();
		
		Genre g = new Genre();
		
		
		
		
	
		m.setMemberId(memberId);
		m.setMemberPwd(memberPwd);
		m.setMemberName(memberName);
		m.setBirthday(birthday);
		m.setGender(gender);
		m.setEmail(email);
		m.setPhone(phone);
		m.setLocalCode(localCode);
		m.setAddress(address);
		
		for(int i = 0; i < genreList.length; i++) {
			g.setGenreName(genreList[i]);
		}
		
		
		new MemberService().insert();
		
		
	}
}
