package com.kh.board.model.service;

import static com.kh.common.JDBCTemplate.*;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Answer;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Category;
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

	// 상세보기
	public Board detailBoard(int boardNo) {
		Connection conn = getConnection();
		Board board = new BoardDao().detailBoard(conn, boardNo);
		close(conn);
		return board;
	}

	public ArrayList<Category> selectCategoryList() {
		Connection conn = getConnection();
		ArrayList<Category> list = new BoardDao().selectCategoryList(conn);
		close(conn);
		
		return list;
	}

	public int insertBoard(Board board) {
		
		Connection conn = getConnection();
		int result = new BoardDao().insertBoard(conn, board);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	
	public int updateBoard(Board board) {
		
		Connection conn = getConnection();
		int result = new BoardDao().updateBoard(conn, board);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int deleteBoard(String boardNo) {
		
		Connection conn = getConnection();
		int result = new BoardDao().deleteBoard(conn, boardNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public List<Answer> selectAnswerList(int boardNo) {
		
		Connection conn = getConnection();
		List<Answer> answer = new BoardDao().selectAnswerList(conn, boardNo);
		
		close(conn);
		return answer;
	}

	public int insertAnswer(Answer answer) {
		
		Connection conn = getConnection();
		int result = new BoardDao().insertAnswer(conn, answer);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
}
