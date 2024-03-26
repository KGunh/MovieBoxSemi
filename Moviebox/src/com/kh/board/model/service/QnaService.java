package com.kh.board.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.QnaDao;
import com.kh.board.model.vo.Board;

public class QnaService {

	public ArrayList<Board> selectQnaList() {
		Connection conn = getConnection();
		
		ArrayList<Board> list = new QnaDao().selectQnaList(conn);
		
		close(conn);
		
		
		return list;
	}

}
