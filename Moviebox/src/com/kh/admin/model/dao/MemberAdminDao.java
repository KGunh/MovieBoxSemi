package com.kh.admin.model.dao;
import static com.kh.common.JDBCTemplate.*;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberAdminDao {
	
	private Properties prop = new Properties();
	
	
	public MemberAdminDao() {
			String sqlFile = MemberAdminDao.class.getResource("/sql/admin/memberAdmin-mapper.xml").getPath();
			try {
				prop.loadFromXML(new FileInputStream(sqlFile));
			} catch (IOException e) {
				e.printStackTrace();
			}
				
				
	}
			
			
	
	public ArrayList<Member> selectMemberAdmin(Connection conn){
		ArrayList<Member> member = new ArrayList<Member>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAdmin");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
		while(rset.next()) {
				Member m = new Member();
							m.setMemberNo(rset.getInt("MEMBER_NO"));
							m.setMemberName(rset.getString("MEMBER_NAME"));
							m.setEnrollDate(rset.getDate("ENROLL_DATE"));
							m.setStatus(rset.getString("STATUS"));
							m.setPhone(rset.getString("PHONE"));
							
							member.add(m);
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return member;	
			
	}
	
	
	
}
	
	
	

