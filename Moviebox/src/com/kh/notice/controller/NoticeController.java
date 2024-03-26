package com.kh.notice.controller;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public void insert(HttpServletRequest request) {
		
		// request.getParameter로 값 뽑기
		String noticeCategory = request.getParameter("category");
		String noticeTitle = request.getParameter("title");
		String noticeContent = request.getParameter("content");
		String userNo = request.getParameter("userNo");
	}

}
