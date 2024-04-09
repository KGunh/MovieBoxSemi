package com.kh.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.admin.model.service.MemberAdminService;
import com.kh.member.model.vo.Member;

public class MemberAdminController {
	
	
	public String selectAdmin(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<Member> member =new MemberAdminService().selectMemberAdmin();
		
		

	
		
	
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
	
	public String updateAdmin(HttpServletRequest request, HttpServletResponse response) {
		
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		Member member  = new Member();
		
		String view = "views/admin/memberModify.jsp";	
		
		String memberId = request.getParameter("memberId");
		String memeberName = request.getParameter("memberName");
		String email = request.getParameter("Email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String status = request.getParameter("status");
		
		
		member.setMemberNo(memberNo);
		member.setMemberId(memberId);
		member.setMemberName(memeberName);
		member.setEmail(email);
		member.setAddress(address);
		member.setPhone(phone);
		member.setStatus(status);
		member.setMemberId(memberId);
		
		System.out.println(member);
		
		//
		
		int result = new MemberAdminService().updateAdmin(member);
		
		if(result > 0) {
			HttpSession session= request.getSession();
			session.setAttribute("alertMsg", "회원 정보가 수정되었습니다.");
//			try {
//				response.sendRedirect(request.getContextPath()+"/modifyAdmin.mb?memberNo=" + memberNo);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				System.out.println("실패");
//				e.printStackTrace();
//			}
			
		} else {
			request.setAttribute("errorMgs", "회원 정보에 실패했습니다.");
			
		
		}
		
		
		
		return request.getContextPath()+"/modifyAdmin.mb?memberNo=" + memberNo; 
		
		
	}
	
	public String  deleteAdmin(HttpServletRequest request, HttpServletResponse response) {
		
		String view = "views/admin/memberSelect.jsp";
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		new MemberAdminService().deleteAdmin(memberNo);
		
		return view; 
		
	}
	

	public String keyword(HttpServletRequest request, HttpServletResponse response) {
		
		String view ="";
		
		
		
		
		return view; 
	}
	

	public String search(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		
		String view = "views/admin/memberSearch.jsp";
		
		String search = request.getParameter("finding");
		String category = request.getParameter("category");
		
		
		switch(category) {
		case "name" : category = "MEMBER_NAME"; break;
		case "enrolldate"  : category = "ENROLL_DATE"; break;
		case "status" : category = "STATUS" ; break; 
		}
		
		
		
		ArrayList<Member> member = new MemberAdminService().search(category, search);
		request.setAttribute("member", member);
		
		
		return view; 
		
		
	}

}
