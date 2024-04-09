package com.kh.goods.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.common.model.vo.PageInfo;
import com.kh.goods.model.dao.GoodsDao;
import com.kh.goods.model.vo.Goods;

public class GoodsService {

	
	public int selectListCount() {
		Connection conn = getConnection();
		
		int listCount = new GoodsDao().selectListCount(conn);
	
		close(conn);
		
		return listCount;
	}
	
	public List<Goods> selectGoodsList(PageInfo pi) {
		Connection conn = getConnection();
		
		List<Goods> goodsList = new GoodsDao().selectGoodsList(conn, pi);
		
		close(conn);
		
		return goodsList;
	}

}
