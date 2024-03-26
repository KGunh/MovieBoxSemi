package com.kh.notice.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

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
	

	// 공지사항 글쓰기
	public String insert(HttpServletRequest request) {
		
		// request.getParameter로 값 뽑기
		String noticeCategory = request.getParameter("category");
		String noticeTitle = request.getParameter("title");
		String noticeContent = request.getParameter("content");
		String memNo = request.getParameter("memNo");
		
		// 객체에 담기
		Notice notice = new Notice();
		notice.setNoticeCategory(noticeCategory);
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		notice.setNoticeWriter(memNo);
		
		// 서비스로 넘기기
		int result = new NoticeService().insert(notice);
		
		String view = "views/notice/noticeInsert.jsp";
		
		return view;
	}

}
