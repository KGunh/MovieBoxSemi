package com.kh.admin.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.model.dao.AdminPageDao;
import com.kh.board.model.vo.Board;
import com.kh.common.model.vo.Genre;
import com.kh.common.model.vo.PageInfo;
import com.kh.movie.model.vo.Movie;
import com.kh.notice.model.vo.Notice;

public class AdminPageService {
	

	// 영화
	public ArrayList<Movie> adminSelectMovieList(PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<Movie> list = new AdminPageDao().adminSelectMovieList(conn, pi);
		
		close(conn);
		
		return list;
	}
	

	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int result = new AdminPageDao().selectListCount(conn);
		
		close(conn);
		
		return result;
	}
	

	// 공지 
	public ArrayList<Notice> adminSelectNoticeList(PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new AdminPageDao().adminSelectNoticeList(conn, pi);
		
		close(conn);
		
		return list;
	}
	

	public int selectListCountNotice() {
		
		Connection conn = getConnection();
		
		int result = new AdminPageDao().selectListCountNotice(conn);
		
		close(conn);
		
		return result;
	}
	
	
	
	// 문의
	public ArrayList<Board> adminSelectQnAList(PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<Board> list = new AdminPageDao().adminSelectQnAList(conn, pi);
		
		close(conn);
		
		return list;
	}
	

	public int selectListCountQnA() {
		
		Connection conn = getConnection();
		
		int result = new AdminPageDao().selectListCountQnA(conn);
		
		close(conn);
		
		return result;
	}
	
	
	
	
	
	
	public ArrayList<Genre> SelectGenreList() {
		
		Connection conn = getConnection();
		
		ArrayList<Genre> genrelist = new AdminPageDao().SelectGenreList(conn);
		
		close(conn);
		
		return genrelist;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
