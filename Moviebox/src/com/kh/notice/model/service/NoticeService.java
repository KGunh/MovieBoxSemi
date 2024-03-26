package com.kh.notice.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.notice.model.dao.NoticeDao;
import com.kh.notice.model.vo.Notice;

public class NoticeService {

	public ArrayList<Notice> selectNoticeList() {
		
		Connection conn = getConnection();
		ArrayList<Notice> list = new NoticeDao().selectNoticeList(conn);
		
		close(conn);
		
		return list;
	}

	
	public Notice selectNotice(int noticeNo) {
		Connection conn = getConnection();
		
		Notice notice = new NoticeDao().selectNotice(conn, noticeNo);
		
		close(conn);
		
		return notice;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 글쓰기
//	public int insert(Notice notice) {
//		
//		Connection conn = getConnection();
//		int result = new NoticeDao().insert(conn, notice);
//		
//		// 트랜잭션?
//		if(result > 0) {
//			commit(conn);
//		} else {
//			rollback(conn);
//		}
//		
//		close(conn);
//		
//		return result;
//	}



}
