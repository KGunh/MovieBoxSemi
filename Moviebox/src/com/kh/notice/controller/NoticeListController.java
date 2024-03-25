package com.kh.notice.controller;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

public class NoticeListController {
	
	public String selectNoticeList(HttpServletRequest request) {
		
		ArrayList<Notice> list = new NoticeService().selectNoticeList();
		
		request.setAttribute("noticeList", list);
		
		String view = "views/notice/noticeList.jsp";
		
		return view;
		
	
		
	}
	


}
