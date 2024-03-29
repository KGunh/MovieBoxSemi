package com.kh.admin.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.model.dao.AdminPageDao;
import com.kh.board.model.vo.Board;
import com.kh.common.model.vo.PageInfo;
import com.kh.movie.model.vo.Movie;
import com.kh.notice.model.vo.Notice;

public class AdminPageService {
	

	// 영화 목록 전체 출력
	public ArrayList<Movie> adminSelectMovieList(PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<Movie> list = new AdminPageDao().adminSelectMovieList(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	
	//페이징바
	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int result = new AdminPageDao().selectListCount(conn);
		
		close(conn);
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	// 공지 목록 전체 출력
	public ArrayList<Notice> adminSelectNoticeList(){
		
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new AdminPageDao().adminSelectNoticeList(conn);
		
		close(conn);
		
		return list;
	}
	
	
	
	// 문의 목록 전체 출력
	public ArrayList<Board> adminSelectQnAList(){
		
		Connection conn = getConnection();
		
		ArrayList<Board> list = new AdminPageDao().adminSelectQnAList(conn);
		
		close(conn);
		
		return list;
	}
	
	

	
	
	
	
	
	
	
	
}
