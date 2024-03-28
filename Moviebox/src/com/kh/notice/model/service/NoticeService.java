package com.kh.notice.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.vo.Category;
import com.kh.notice.model.dao.NoticeDao;
import com.kh.notice.model.vo.Notice;

public class NoticeService {

	public ArrayList<Notice> selectNoticeList() {
		
		Connection conn = getConnection();
		ArrayList<Notice> list = new NoticeDao().selectNoticeList(conn);
		
		close(conn);
		
		return list;
	}

	// 공지사항 조회
	public Notice selectNotice(int noticeNo) {
		Connection conn = getConnection();
		
		Notice notice = new NoticeDao().selectNotice(conn, noticeNo);
		
		close(conn);
		
		return notice;
		
	}
	
	// 공지사항 조회
	public Notice updateNoticeForm(int noticeNo) {
		Connection conn = getConnection();
		
		Notice notice = new NoticeDao().selectNotice(conn, noticeNo);
		
		close(conn);
		
		return notice;
		
	}
	
	
	// 공지사항 글쓰기
	public int insertNotice(Notice notice) {
		
		Connection conn = getConnection();
		
		int result = new NoticeDao().insertNotice(conn, notice);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	
	// 카테고리
	public ArrayList<Category> selectCategoryList(){
		Connection conn = getConnection();
		
		ArrayList<Category> list = new NoticeDao().selectCategoryList(conn);
		
		close(conn);
		
		return list;
	}
	
	
	// 공지사항 글 수정
	public int updateNotice(Notice notice) {
		
		Connection conn = getConnection();
		
		int result = new NoticeDao().updateNotice(conn, notice);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	
	public int removeNotice(String noticeNo) {
		
		Connection conn = getConnection();
		int result = new NoticeDao().removeNotice(conn, noticeNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	


}
