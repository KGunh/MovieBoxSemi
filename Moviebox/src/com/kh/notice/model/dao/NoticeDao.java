package com.kh.notice.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.model.vo.Category;
import com.kh.notice.model.vo.Notice;

public class NoticeDao {
	
	private Properties prop = new Properties();
	
	public NoticeDao() {
		
		String fileName = NoticeDao.class.getResource("/sql/notice/notice-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	// 공지사항 목록 전체 출력 
	public ArrayList<Notice> selectNoticeList(Connection conn) {
		ArrayList<Notice> list = new ArrayList();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectNoticeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Notice notice = new Notice();
				
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setNoticeCategory(rset.getString("CATEGORY_NAME"));
				notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				notice.setCount(rset.getInt("COUNT"));
				notice.setCreateDate(rset.getString("CREATE_DATE"));
			
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
	
	
	public int increaseCount(Connection conn, int noticeNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, noticeNo);
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	// 공지사항 조회
	public Notice selectNotice(Connection conn, int noticeNo) {
		
		Notice n = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, noticeNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				n = new Notice();
				n.setNoticeCategory(rset.getString("CATEGORY_NAME"));
				n.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				n.setCreateDate(rset.getString("CREATE_DATE"));
				n.setCount(rset.getInt("COUNT"));
				n.setNoticeWriter(rset.getString("NOTICE_WRITER"));
				n.setNoticeContent(rset.getString("NOTICE_CONTENT"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return n;
	}
	
	
	// 공지사항 글쓰기
	public int insertNotice(Connection conn, Notice notice) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setInt(2, notice.getUserNo());
			pstmt.setString(3, notice.getNoticeContent());
			pstmt.setInt(4, notice.getCategoryNo());
			
			
			result = pstmt.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public ArrayList<Category> selectCategoryList(Connection conn){
		
		ArrayList<Category> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCategoryList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Category(
									 rset.getInt("CATEGORY_NO"),
									 rset.getString("CATEGORY_NAME")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	// 글쓰기
//	public int insert(Connection conn, Notice notice) {
//		
//		int result = 0;
//		PreparedStatement pstmt = null;
//		String sql = prop.getProperty("insert");
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, notice.getNoticeCategory());
//			pstmt.setString(2, notice.getNoticeTitle());
//			pstmt.setString(3, notice.getNoticeContent());
//			pstmt.setInt(4, Integer.parseInt(notice.getNoticeWriter()));
//			
//			result = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		
//		return result;
//	}



}
