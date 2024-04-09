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
		
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("selectGoodsList"));
			ResultSet rset = pstmt.executeQuery();) {
			
			while(rset.next()) {
				Goods goods = new Goods();
				
				goods.setChangeName(rset.getString("CHANGE_NAME"));
				goods.setGoodsName(rset.getString("GOODS_NAME"));
				goods.setGoodsPrice(rset.getInt("GOODS_PRICE"));
				goods.setTypeName(rset.getString("TYPE_NAME"));
				goods.setFilePath(rset.getString("FILE_PATH"));
				goods.setGoodsNo(rset.getInt("GOODS_NO"));
				System.out.println(goods.getChangeName()+goods.getFilePath());
				goodsList.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goodsList;
	}

}
