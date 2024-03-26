package com.kh.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.model.dao.MemberAdminDao;
import com.kh.admin.model.service.MemberAdminService;
import com.kh.member.model.vo.Member;

public class MemberAdminController {
	
	
	public void selectAdmin(HttpServletRequest request) {
		
		List<Member> member =new MemberAdminService().selectMemberAdmin();
		

		for(int i = 0; i<member.size(); i++) {
			
			request.setAttribute("memberNo", member.get(i).getMemberNo());
			request.setAttribute("memberName", member.get(i).getMemberName());
			request.setAttribute("enrollDate", member.get(i).getEnrollDate());
			request.setAttribute("status", member.get(i).getStatus());
			request.setAttribute("phone", member.get(i).getPhone());
			
			//request.getRequestDispatcher("views/admin/memberSelect.jsp").forward(request, response);		
		
			
		}
		
		
		
		
	}
	
	public String editAdmin(HttpServletRequest request) {
		
		
		return "views/admin/editAdmin.mb";
		
		
		
		
	}
	
	
	

}
