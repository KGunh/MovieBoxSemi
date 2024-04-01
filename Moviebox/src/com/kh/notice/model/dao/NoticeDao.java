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
import com.kh.common.model.vo.PageInfo;
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
	public ArrayList<Notice> selectNoticeList(Connection conn, PageInfo pi) {
		ArrayList<Notice> list = new ArrayList();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectNoticeList");
		
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
	
	// 페이징바
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
	public Notice detailNotice(Connection conn, int noticeNo) {
		
		Notice notice = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("detailNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, noticeNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				notice = new Notice();
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setNoticeCategory(rset.getString("CATEGORY_NAME"));
				notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				notice.setCreateDate(rset.getString("CREATE_DATE"));
				notice.setCount(rset.getInt("COUNT"));
				notice.setNoticeWriter(rset.getString("NOTICE_WRITER"));
				notice.setNoticeContent(rset.getString("NOTICE_CONTENT"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return notice;
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
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	
	public int updateNotice(Connection conn, Notice notice) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, notice.getCategoryNo());
			pstmt.setString(2, notice.getNoticeTitle());
			pstmt.setString(3, notice.getNoticeContent());
			pstmt.setInt(4, notice.getNoticeNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public int deleteNotice(Connection conn, String noticeNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(noticeNo));
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public int countNotice(Connection conn, int noticeNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("countNotice");
		
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


	public int noticeListCount(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("noticeListCount");
		
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
