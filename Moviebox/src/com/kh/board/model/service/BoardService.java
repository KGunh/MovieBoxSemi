package com.kh.board.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Board;
import com.kh.common.model.vo.PageInfo;

public class BoardService {

	// 전체 목록 출력
	public ArrayList<Board> selectBoardList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Board> list = new BoardDao().selectBoardList(conn, pi);
		close(conn);
		
		return list;
	}
	
	// 페이징바
	public int selectListCount() {
		Connection conn = getConnection();
		int result = new BoardDao().selectListCount(conn);
		close(conn);
		return result;
	}

	public Board detailBoard(int boardNo) {
		Connection conn = getConnection();
		Board board = new BoardDao().detailBoard(conn, boardNo);
		close(conn);
		return board;
	}

}
