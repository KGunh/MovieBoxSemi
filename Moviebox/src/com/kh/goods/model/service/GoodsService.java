package com.kh.goods.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.goods.model.dao.GoodsDao;
import com.kh.goods.model.vo.Goods;

public class GoodsService {

	public List<Goods> selectGoodsList() {
		Connection conn = getConnection();
		
		List<Goods> goodsList = new GoodsDao().selectGoodsList(conn);
		
		close(conn);
		
		return goodsList;
	}

}
