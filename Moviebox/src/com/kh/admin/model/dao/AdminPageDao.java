package com.kh.admin.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import static com.kh.common.JDBCTemplate.*;
import com.kh.movie.model.vo.Movie;

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
				movie.setGenreNo(rset.getString(" GENRE_NAME"));
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
