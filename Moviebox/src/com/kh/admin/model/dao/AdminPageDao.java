package com.kh.admin.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.movie.model.vo.Movie;
import com.kh.notice.model.vo.Notice;

public class AdminPageDao {

	private Properties prop = new Properties();
	
	public AdminPageDao() {
		
		String fileName = AdminPageDao.class.getResource("/sql/admin/admin-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//영화 목록 전체 출력
	public ArrayList<Movie> adminSelectMovieList(Connection conn){
		
		
		ArrayList<Movie> list = new ArrayList();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("adminSelectMovieList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Movie movie = new Movie();
				
				movie.setMovieNo(rset.getInt("MOVIE_NO"));
				movie.setMovieRelease(rset.getString("MOVIE_RELEASE"));
				movie.setMovieTitle(rset.getString("MOVIE_TITLE"));
				movie.setMovieRated(rset.getString("MOVIE_RATED"));
				movie.setGenreNo(rset.getString("GENRE_NAME"));
				movie.setMovieUpdate(rset.getString("MOVIE_UPDATE"));
				
				list.add(movie);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
	
	
	//공지 목록 전체 출력
	public ArrayList<Notice> adminSelectNoticeList(Connection conn){
		
		ArrayList<Notice> list = new ArrayList();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("adminSelectNoticeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			Notice notice = new Notice();
			
			notice.setNoticeNo(rset.getInt("NOTICE_NO"));
			notice.setNoticeCategory(rset.getString("CATEGORY_NAME"));
			notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
			notice.setCreateDate(rset.getString("CREATE_DATE"));
			notice.setCount(rset.getInt("COUNT"));
			
			list.add(notice);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
		
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
