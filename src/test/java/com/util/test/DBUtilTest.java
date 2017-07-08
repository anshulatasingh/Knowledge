package com.util.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.util.DBUtil;

public class DBUtilTest {

	@Test
	public void testClose() {
		
		Connection con=DBUtil.getConnection();
		try {
			String sql="create table names(name varchar(200))";
			Statement st=con.createStatement();
			try{
				st.executeUpdate(sql);
			}catch(Exception e){
				
			}
			
			ResultSet rs=st.executeQuery("select * from names");

DBUtil.close(rs, null, null);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	
	}

}
