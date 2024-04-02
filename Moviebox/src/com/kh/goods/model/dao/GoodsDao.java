package com.kh.goods.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.goods.model.vo.Goods;

public class GoodsDao {
	
	private Properties prop = new Properties();
	
	public GoodsDao() {
		String filePath = GoodsDao
						.class
						.getResource("/sql/goods/goods-mapper.xml")
						.getPath();
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Goods> selectGoodsList(Connection conn) {
		List<Goods> goodsList = new ArrayList<Goods>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectGoodsList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return goodsList;
	}

}
