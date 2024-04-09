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

import com.kh.common.model.vo.PageInfo;
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
	
	public int selectListCount(Connection conn) {
		int listCount = 0;
		
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("selectListCount"));
			ResultSet rset = pstmt.executeQuery();) {
			
			rset.next();
			
			listCount = rset.getInt("COUNT(*)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return listCount;
	}


	public List<Goods> selectGoodsList(Connection conn, PageInfo pi) {
		List<Goods> goodsList = new ArrayList<Goods>();
		
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("selectGoodsList"));) {
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			try(ResultSet rset = pstmt.executeQuery();) {
			
				while(rset.next()) {
					Goods goods = new Goods();
					
					goods.setChangeName(rset.getString("CHANGE_NAME"));
					goods.setGoodsName(rset.getString("GOODS_NAME"));
					goods.setGoodsPrice(rset.getInt("GOODS_PRICE"));
					goods.setTypeName(rset.getString("TYPE_NAME"));
					goods.setFilePath(rset.getString("FILE_PATH"));
					goods.setGoodsNo(rset.getInt("GOODS_NO"));
					
					goodsList.add(goods);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return goodsList;
	}

	
	
	
	
	
	
}
