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

import com.kh.board.model.vo.Board;
import com.kh.common.model.vo.Genre;
import com.kh.common.model.vo.PageInfo;
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
	public ArrayList<Movie> adminSelectMovieList(Connection conn, PageInfo pi){
		
		
		ArrayList<Movie> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectMovieList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
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
	
	
	public int selectListCount(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			rset.next();
			
			listCount = rset.getInt("COUNT(*)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	
	
	
	
	
	
	
	
	
	
	//공지 목록 전체 출력
	public ArrayList<Notice> adminSelectNoticeList(Connection conn,  PageInfo pi){
		
		ArrayList<Notice> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectNoticeList");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Notice notice = new Notice();
				
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setNoticeCategory(rset.getString("CATEGORY_NAME"));
				notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				notice.setCreateDate(rset.getString("CREATE_DATE"));
				notice.setCount(rset.getInt("COUNT"));
				
				list.add(notice);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
		
	}	
	
	
	public int selectListCountNotice(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCountNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			rset.next();
			
			listCount = rset.getInt("COUNT(*)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//문의 목록 전체 출력
	public ArrayList<Board> adminSelectQnAList(Connection conn,  PageInfo pi){
		
		ArrayList<Board> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectQnAList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Board board = new Board();
				
				board.setBoardNo(rset.getInt("BOARD_NO"));
				board.setBoardCategory(rset.getString("CATEGORY_NO"));
				board.setBoardTitle(rset.getString("BOARD_TITLE"));
				board.setBoardWriter(rset.getString("MEMBER_ID"));
				board.setCreateDate(rset.getString("CREATE_DATE"));
				board.setCount(rset.getInt("COUNT"));
				
				list.add(board);
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
	
	
	public int selectListCountQnA(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCountQnA");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			rset.next();
			
			listCount = rset.getInt("COUNT(*)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	
	
	
	
	
	
	
	public ArrayList<Genre> SelectGenreList(Connection conn){
		
		ArrayList<Genre> genrelist = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("SelectGenreList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				genrelist.add(
						new Genre(
								rset.getString("GENRE_CODE"),
								rset.getString("GENRE_NAME")
								));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return genrelist;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
