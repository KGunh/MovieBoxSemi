package com.kh.notice.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.model.vo.Category;
//import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.vo.Member;
import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

public class NoticeController {
	
	// 공지사항 전체 리스트 출력
	public String selectNoticeList(HttpServletRequest request) {
		
//		int listCount;
//		int currentPage;
//		int pageLimit;
//		int boardLimit;	
//		int maxPage;
//		int startPage;
//		int endPage;
//		
//		// 전체 공지사항 수 
//		listCount = new NoticeService().noticeListCount();
//		
//		// 현재 페이지 (사용자의 요청 페이지)
//		currentPage = Integer.parseInt(request.getParameter("currentPage"));
//		
//		pageLimit = 10;
//		boardLimit = 10;
//		
//		maxPage = (int)Math.ceil((double)listCount / boardLimit);
//		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
//		endPage = startPage + pageLimit - 1;
//		
//		if(endPage > maxPage) {
//			endPage = maxPage;
//		}
//		
//		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit,
//				   maxPage, startPage, endPage);
//		
//		
		ArrayList<Notice> list = new NoticeService().selectNoticeList();
		
		
//		request.setAttribute("pageInfo", pi);
		request.setAttribute("noticeList", list);
		
		String view = "views/notice/noticeList.jsp";
		
		return view;
	}
	
	// 글 조회
	public String detailNotice(HttpServletRequest request, HttpServletResponse response) {

		// 글 조회 목록
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		// 조회수
		int result = new NoticeService().countNotice(noticeNo);
		
		Notice notice = new NoticeService().detailNotice(noticeNo);
		request.setAttribute("notice", notice);
		request.setAttribute("count", result);
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
			session.setAttribute("alertMsg", "공지사항이 등록되었습니다.");
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
		Notice notice = new NoticeService().detailNotice(noticeNo);
		
		request.setAttribute("notice", notice);
		
		String view = "views/notice/noticeUpdateForm.jsp";
		
		return view;
	}
	
	// 글 수정
	public String updateNotice(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();

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
			session.setAttribute("alertMsg", "수정 되었습니다.");
			view = "/detail.notice?noticeNo=" + noticeNo;
		} else {
			session.setAttribute("alertMsg", "공지사항 수정 실패");
			view = "view/notice/noticeUpdateForm.jsp";
		}
		
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
		Notice notice = new NoticeService().detailNotice(noticeNo);
		
		request.setAttribute("category", list);
		request.setAttribute("notice", notice);

		String view = "views/notice/noticeUpdateForm.jsp";
		
		return view;
	}
	
	// 삭제
	public String removeNotice(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		String noticeNo = request.getParameter("noticeNo");
		int result = new NoticeService().removeNotice(noticeNo);
		
		String view ="";
		
		if(result > 0) {
			session.setAttribute("alertMsg", "삭제되었습니다.");
			view = "/list.notice";
		} else {
			session.setAttribute("alertMsg", "삭제 실패");
			view = "/list.notice";
		}
		
		return view;
	}
	
	

	

	

}
