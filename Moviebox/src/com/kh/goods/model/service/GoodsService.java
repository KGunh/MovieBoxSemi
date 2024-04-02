package com.kh.goods.model.service;

import java.sql.Connection;

import com.kh.goods.model.dao.GoodsDao;

import static com.kh.common.JDBCTemplate.*;

public class GoodsService {

	public void selectGoodsList() {
		Connection conn = getConnection();
		
		new GoodsDao().selectGoodsList(conn);
		
		close(conn);
		
	}

}
