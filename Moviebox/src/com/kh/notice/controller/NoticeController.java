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
	
	// 로그인 여부
	public String insertFormNotice(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();		
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		String view = "";
		if(loginUser != null && loginUser.getMemberId().equals("admin")) {
			view = "views/notice/noticeInsertForm.jsp";
		} else {
			session.setAttribute("alertMsg", "관리자로 로그인 해주세요.");
			view = "/list.notice";
		}
		
		return view;
	}
	
	// 카테고리 (글 작성)
	public String selectCategoryList(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Category> list = new NoticeService().selectCategoryList();
		request.setAttribute("category", list);
		
		String view = "views/notice/noticeInsertForm.jsp";

		return view;
	}
	
	// 카테고리 (글 수정)
	public String selectCategory(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Category> list = new NoticeService().selectCategoryList();
		request.setAttribute("category", list);
		
		String view = "views/notice/noticeUpdateForm.jsp";

		return view;
	}
	
	
	// 글 수정 (카테고리, 공지사항 번호 넘겨주기)
	public String updateNoticeList(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Category> list = new NoticeService().selectCategoryList();

		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		Notice notice = new NoticeService().selectNotice(noticeNo);
		
		request.setAttribute("category", list);
		request.setAttribute("notice", notice);

		String view = "views/notice/noticeUpdateForm.jsp";
		
		return view;
	}
	
	
	// 공지사항 글쓰기
	public String insertNotice(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		int categoryNo = Integer.parseInt(request.getParameter("category"));
		String noticeTitle = request.getParameter("title");
		String noticeContent = request.getParameter("content");
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		// 가공
		Notice notice = new Notice();
		notice.setCategoryNo(categoryNo);
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		notice.setUserNo(userNo);
		
		int result = new NoticeService().insertNotice(notice);
		request.setAttribute("noticeInsert", result);
		
		String view = "";
		
		if(result > 0) {
			view = "/list.notice";
		} else {
			session.setAttribute("alertMsg", "공지사항 작성 실패");
			view = "views/member/noticeInsertForm.jsp";
		}
		
		return view;
	}
	
	//  글 수정
	public String updateNoticeForm(HttpServletRequest request, HttpServletResponse response) {
		
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		Notice notice = new NoticeService().selectNotice(noticeNo);
		
		request.setAttribute("notice", notice);
		
		String view = "views/notice/noticeUpdateForm.jsp";
		
		return view;
	}
	
	// 글 수정
	public String updateNotice(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
//		int categoryNo = 0;
//		String noticeCategory = request.getParameter("category");
//		
//		switch(noticeCategory) {
//		case "영화" : categoryNo = 1;
//		case "영화관" : categoryNo = 2;
//		case "굿즈" : categoryNo = 3;
//		case "기타" : categoryNo = 4;
//		}
		
		
		int noticeCategory = Integer.parseInt(request.getParameter("category"));
		
		String noticeTitle = request.getParameter("title");
		String noticeContent = request.getParameter("content");
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		Notice notice = new Notice();
		notice.setCategoryNo(noticeCategory);
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		notice.setNoticeNo(noticeNo);
		
		int result = new NoticeService().updateNotice(notice);
		request.setAttribute("notice", result);
		
		String view = "";
		
		if(result > 0) {
			view = "/update.notice?noticeNo=" + noticeNo;
		} else {
			session.setAttribute("alertMsg", "공지사항 수정 실패");
			view = "view/notice/noticeUpdateForm.jsp";
		}
		
		return view;
	}
	
	// 페이징
	
	

	

	

}
