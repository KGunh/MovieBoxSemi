package com.kh.movie.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.model.vo.Attachment;
import com.kh.movie.model.vo.Movie;

public class MovieDao {
	
	private Properties prop = new Properties();
	
	public MovieDao() {
		String fileName = MovieDao.class.getResource("/sql/movie/movie-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Movie> selectMovieList(SqlSession sqlSession) {
				
		return sqlSession.selectList("movieMapper.selectMovieList");
	}

	public ArrayList<Movie> movieCategory(Connection conn, String genre) {
		
		ArrayList<Movie> list = new ArrayList<Movie>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("movieCategory");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, genre);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Movie movie = new Movie();
				movie.setMovieNo(rset.getInt("MOVIE_NO"));
				movie.setMovieTitle(rset.getString("MOVIE_TITLE"));
				movie.setMovieRt(rset.getString("MOVIE_RT"));
				movie.setMovieRated(rset.getString("MOVIE_RATED"));
				movie.setMovieRelease(rset.getString("MOVIE_RELEASE"));
				movie.setMovieStory(rset.getString("MOVIE_STORY"));
				movie.setStatus(rset.getString("STATUS"));
				movie.setGenreName(rset.getString("GENRE_NAME"));
				movie.setDirectorNo(rset.getInt("DIRECTOR_NO"));
				movie.setFilePath(rset.getString("FILE_PATH"));
				movie.setChangeName(rset.getString("CHANGE_NAME"));
										
				list.add(movie);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}

	public Movie detailMovie(Connection conn, int movieNo) {
		
		Movie m = new Movie();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("detailMovie");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, movieNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m.setMovieNo(rset.getInt("MOVIE_NO"));
				m.setMovieTitle(rset.getString("MOVIE_TITLE"));
				m.setMovieRt(rset.getString("MOVIE_RT"));
				m.setMovieRated(rset.getString("MOVIE_RATED"));
				m.setMovieRelease(rset.getString("MOVIE_RELEASE"));
				m.setMovieStory(rset.getString("MOVIE_STORY"));
				m.setStatus(rset.getString("STATUS"));
				m.setGenreNo(rset.getString("GENRE_NO"));
				m.setGenreName(rset.getString("GENRE_NAME"));
				m.setDirectorNo(rset.getInt("DIRECTOR_NO"));
				m.setDirectorName(rset.getString("DIRECTOR_NAME"));
				m.setMovieUpdate(rset.getString("MOVIE_UPDATE"));
				m.setFilePath(rset.getString("FILE_PATH"));
				m.setChangeName(rset.getString("CHANGE_NAME"));
				m.setTrailerVideo(rset.getString("TRAILER_VIDEO"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pstmt);
		}
		
		return m;
	}

	public String detailMovieCast(Connection conn, int movieNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("detailMovieCast");
		
		String cast = "";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, movieNo);
			
			rset = pstmt.executeQuery();
			
			rset.next();
			
			cast = rset.getString("ACTOR_NAMES");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return cast;
	}

	public ArrayList<Attachment> stilCut(Connection conn, int movieNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("stilCut");
		
		ArrayList<Attachment> stilCutList = new ArrayList();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, movieNo);
			rset = pstmt.executeQuery();
			
	        while (rset.next()) {
	        	Attachment attach = new Attachment();
	        	attach.setMovieNo(rset.getInt("MOVIE_NO"));
	        	attach.setFilePath(rset.getString("FILE_PATH"));
	        	attach.setChangeName(rset.getString("CHANGE_NAME"));
	        	
	        	stilCutList.add(attach);
	        }
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return stilCutList;
	}

	
	
	
	
	
	
	
	
	
	
	
	

}
