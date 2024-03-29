package com.kh.board.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Board;

public class BoardService {

	// 전체 목록 출력
	public ArrayList<Board> selectBoardList() {
		Connection conn = getConnection();
		
		ArrayList<Board> list = new BoardDao().selectBoardList(conn);
		
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
