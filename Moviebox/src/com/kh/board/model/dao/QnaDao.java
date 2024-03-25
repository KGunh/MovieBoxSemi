package com.kh.board.model.dao;

import static com.kh.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.model.vo.Board;
import com.kh.notice.model.dao.NoticeDao;

public class QnaDao {
	
	private Properties prop = new Properties();
	
	public QnaDao() {
		
		String fileName = NoticeDao.class
				.getResource("/sql/board/qna-mapper.xml")
				.getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Board> selectQnaList(Connection conn) {
		
		ArrayList<Board> list = new ArrayList();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectQnaList");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Board board = new Board();
				
				board.setBoardNo(rset.getInt("BOARD_NO"));
				board.setBoardCategory(rset.getString("BOARD_CATEGORY"));
				board.setBoardTitle(rset.getString("BOARD_TITLE"));
				board.setBoardWriter(rset.getString("BOARD_WRITER"));
				board.setCreateDate(rset.getString("CREATE_DATE"));
				
				list.add(board);
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

}
