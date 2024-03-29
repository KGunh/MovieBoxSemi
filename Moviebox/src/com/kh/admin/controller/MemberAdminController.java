package com.kh.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.admin.model.service.MemberAdminService;
import com.kh.member.model.vo.Member;

public class MemberAdminController {
	
	
	public String selectAdmin(HttpServletRequest request, HttpServletResponse response) {
		
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
	
	public String detailAdmin(HttpServletRequest request, HttpServletResponse response) {
		
			int memberNo = Integer.parseInt(request.getParameter("memberNo"));
			String view = "";

			
			Member m =new MemberAdminService().detailAdmin(memberNo);
			
			
			if(m != null) {
				request.setAttribute("member", m);
				view = "views/admin/memberModify.jsp";
				
			}else {
				view = "index.jsp";
			}
			
		
			
		
		
		
		
		
		
		return view;
		
	}
	
	public void updateAdmin(HttpServletRequest request, HttpServletResponse response) {
		
		Member member  = new Member();
		
		String view = "";	
		
		String memberId = request.getParameter("memberId");
		String memeberName = request.getParameter("memberName");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String status = request.getParameter("status");
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		
	
		member.setMemberId(memberId);
		member.setMemberName(memeberName);
		member.setEmail(email);
		member.setAddress(address);
		member.setPhone(phone);
		member.setStatus(status);
		member.setMemberId(memberId);
		
		
		//
		
		int result = new MemberAdminService().updateAdmin(member);
		
		if(result > 0) {
			HttpSession session= request.getSession();
			session.setAttribute("alertMsg", "회원 정보가 수정되었습니다.");
			try {
				response.sendRedirect(request.getContextPath()+"/modifyAdmin.mb?memberNo=" + memberNo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			request.setAttribute("errorMgs", "회원 정보에 실패했습니다.");
			
		
		}
		
		
		
		
		
		
	}
	
	
	
	

}
