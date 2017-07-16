package com.normal.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.backend.models.InfoVo;
import com.exception.GenericException;
import com.util.DBUtil;

public class InfoTest {
	
	public static void main(String[] args) {
		
		addInfo(new InfoVo(2,2,"2017-01-01","Language-java","JavaTest"));
		
		getAllInfo().forEach(vo -> System.out.println(vo));
	}
	
	public static int addInfo(InfoVo infoData) throws GenericException {

		// 1: create sql query
		// 2: get connection
		// 3: create statement
		// 4:submit the sql query to dataase
		// 5: process the result
		// 6:close the connection

		String query = "insert into info(nodeid,c_date,label,description) values(?,?,?,?)";
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(query);

			pst.setInt(1, infoData.getNodeId());
			pst.setString(2, infoData.getCreationDate());
			pst.setString(3, infoData.getLabel());
			pst.setString(4, infoData.getDescription());
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error while inserting Node data");
			throw new GenericException("InfoDaoImpl", "Error while inserting Node data", e);
		} finally {
			DBUtil.close(null, pst, con);
		}
	}
	
	public static List<InfoVo> getAllInfo() throws GenericException {
		List<InfoVo> result=new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query = "select * from info";
		
		try {
			con = DBUtil.getConnection(); 
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();			
			if (rs != null) {
				if (rs.next()) {
					InfoVo vo = new InfoVo();
					vo.setId(rs.getInt("infoId"));
					vo.setNodeId(rs.getInt("nodeId"));
					vo.setCreationDate(rs.getString("c_date"));
					vo.setLabel(rs.getString("label"));
					vo.setDescription(rs.getString("description"));
					result.add(vo);
				}
			}
			return result;

		} catch (SQLException e) {
			System.out.println("Error while inserting Node data");
			throw new GenericException("NodeDaoImpl", "Error while inserting Node data", e);
		} finally {
			DBUtil.close(rs, pst, con);
		}
	}

}
