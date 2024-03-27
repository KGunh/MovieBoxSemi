package com.kh.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.model.dao.MemberAdminDao;
import com.kh.admin.model.service.MemberAdminService;
import com.kh.member.model.vo.Member;

public class MemberAdminController {
	
	
	public String selectAdmin(HttpServletRequest request) {
		
		ArrayList<Member> member =new MemberAdminService().selectMemberAdmin();
		
		System.out.println(member);

		/*
		
		for(int i = 0; i<member.size(); i++) {
			
			request.setAttribute("memberNo", member.get(i).getMemberNo());
			request.setAttribute("memberName", member.get(i).getMemberName());
			request.setAttribute("enrollDate", member.get(i).getEnrollDate());
			request.setAttribute("status", member.get(i).getStatus());
			request.setAttribute("phone", member.get(i).getPhone());
			
			//request.getRequestDispatcher("views/admin/memberSelect.jsp").forward(request, response);		
		
		
		}
		
		*/	
		request.setAttribute("member", member);
		
		String view = "views/admin/memberSelect.jsp";
		return view;
		
	}
	
	public String editAdmin(HttpServletRequest request) {
		
			int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		
			Member m =new MemberAdminService().editAdmin(memberNo);
			
		
		request.setAttribute("member", m);
		
		
		
		return "views/admin/modifyAdmin.mb";
		
		
		
		
	}
	
	
	

}
