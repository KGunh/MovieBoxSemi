package com.kh.notice.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.model.vo.Category;
import com.kh.member.model.vo.Member;
import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

public class NoticeController {
	
	// 공지사항 전체 리스트 출력
	public String selectNoticeList(HttpServletRequest request) {
		
		ArrayList<Notice> list = new NoticeService().selectNoticeList();
		request.setAttribute("noticeList", list);
		String view = "views/notice/noticeList.jsp";
		
		// view 전달 
		return view;
	}
	
	// 공지사항 조회
	public String selectNotice(HttpServletRequest request, HttpServletResponse response) {
		
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		Notice notice = new NoticeService().selectNotice(noticeNo);
		request.setAttribute("notice", notice);
		String view = "views/notice/noticeDetail.jsp";
		
		return view;
		
	}
//	
//	// 로그인 여부
//	public void noticeLoginForm(HttpServletRequest request, HttpServletResponse response) {
//		HttpSession session = request.getSession();
//		Member loginUser = (Member)session.getAttribute("loginUser");
//		
//		if(loginUser != null && loginUser.getMemberId().equals("admin")) {
//			request.getRequestDispatcher;
//		} else {
//			session.setAttribute("arertMsg", "관리자도 아니면서 감히~~~~~~~");
//			response.sendRedirect(request.getContextPath());
//		}
//		
//		
//	}
//	
	// 공지사항 글쓰기
	public String insertNotice(HttpServletRequest request, HttpServletResponse response) {
		
		String noticeCategory = request.getParameter("category");
		String noticeTitle = request.getParameter("title");
		String noticeContent = request.getParameter("content");
		
		// 가공
		Notice notice = new Notice();
		notice.setNoticeCategory(noticeCategory);
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		
		int result = new NoticeService().insertNotice(notice);
		request.setAttribute("noticeInsert", result);
		
		String view = "views/notice/noticeInsert.jsp";
		
		
		return view;
	}

	
	// 카테고리
	public String selectCategoryList(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Category> list = new NoticeService().selectCategoryList();
		request.setAttribute("categoryList", list);
		
		String view = "views/notice/noticeInsert.jsp";
		
		return view;
		
	}
	
	
	
	
	

//	// 공지사항 글쓰기
//	public String insert(HttpServletRequest request) {
//		
//		// request.getParameter로 값 뽑기
//		String noticeCategory = request.getParameter("category");
//		String noticeTitle = request.getParameter("title");
//		String noticeContent = request.getParameter("content");
//		String userNo = request.getParameter("userNo");
//		
//		// 객체에 담기
//		Notice notice = new Notice();
//		notice.setNoticeCategory(noticeCategory);
//		notice.setNoticeTitle(noticeTitle);
//		notice.setNoticeContent(noticeContent);
//		notice.setNoticeWriter(userNo);
//		
//		// 서비스로 넘기기
//		int result = new NoticeService().insert(notice);
//		
//		String view = "views/notice/noticeInsert.jsp";
//		
//		return view;
//	}

}
