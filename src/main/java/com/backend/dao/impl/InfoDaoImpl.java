package com.backend.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Ignore;

import com.backend.dao.InfoDao;
import com.backend.models.InfoVo;
import com.exception.GenericException;
import com.util.DBUtil;

public class InfoDaoImpl implements InfoDao {

	private static final Logger LOGGER = Logger.getLogger(InfoDaoImpl.class);

	@Override
	public int addInfo(InfoVo infoData) throws GenericException {

		// 1: create sql query
		// 2: get connection
		// 3: create statement
		// 4:submit the sql query to dataase
		// 5: process the result
		// 6:close the connection

		String query = "insert into info values(?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(query);

			pst.setInt(1, generateInfoId());
			pst.setInt(2, infoData.getNodeId());
			pst.setString(3, infoData.getCreationDate());
			pst.setString(4, infoData.getLabel());
			pst.setString(5, infoData.getDescription());
			return pst.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error("Error while inserting Node data", e);
			throw new GenericException("InfoDaoImpl",
					"Error while inserting Node data", e);
		} finally {
			DBUtil.close(null, pst, con);
		}
	}

	@Override
	public void addInfos(List<InfoVo> infoData) throws GenericException {
		for (InfoVo infoVo : infoData)
			addInfo(infoVo);
	}

	@Override
	public InfoVo getInfoByInfoId(int infoId) throws GenericException {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query = "select * from Info where InfoId=?";
		InfoVo vo = new InfoVo();
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(query);
			pst.setInt(1, infoId);
			rs = pst.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					vo.setId(rs.getInt("infoId"));
					vo.setNodeId(rs.getInt("nodeId"));
					vo.setCreationDate(rs.getString("c_date"));
					vo.setLabel(rs.getString("label"));
					vo.setDescription(rs.getString("description"));
				}

			}
			return vo;

		} catch (SQLException e) {
			LOGGER.error("Error while inserting Node data", e);
			throw new GenericException("NodeDaoImpl",
					"Error while inserting Node data", e);
		} finally {
			DBUtil.close(rs, pst, con);
		}
	}

	@Override
	public List<InfoVo> getInfoByNodeId(int nodeId) throws GenericException {

		List<InfoVo> listdata = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query = "select * from Info where NodeId=?";

		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(query);
			pst.setInt(1, nodeId);
			rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					InfoVo vo = new InfoVo();
					vo.setId(rs.getInt("infoId"));
					vo.setNodeId(rs.getInt("nodeId"));
					vo.setCreationDate(rs.getString("c_date"));
					vo.setLabel(rs.getString("label"));
					vo.setDescription(rs.getString("description"));
					listdata.add(vo);
				}

			}
			return listdata;

		} catch (SQLException e) {
			LOGGER.error("Error while inserting Node data", e);
			throw new GenericException("NodeDaoImpl",
					"Error while inserting Node data", e);
		} finally {
			DBUtil.close(rs, pst, con);
		}
	}

	@Override
	public int updateInfoByInfoId(InfoVo infoVo) throws GenericException {

		Connection con = null;
		PreparedStatement pst = null;
		String query = "update info set label=?,c_date=? ,description=? where infoid=?";

		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, infoVo.getLabel());
			pst.setString(2, infoVo.getCreationDate());
			pst.setString(3, infoVo.getDescription());
			pst.setInt(4, infoVo.getId());
			return pst.execute() ? 1 : 0;

		} catch (SQLException e) {
			LOGGER.error("Error while inserting Node data", e);
			throw new GenericException("NodeDaoImpl",
					"Error while inserting Node data", e);
		} finally {
			DBUtil.close(null, pst, con);
		}
	}

	@Override
	public int updateInfoByNodeId(InfoVo infoVo) throws GenericException {
		Connection con = null;
		PreparedStatement pst = null;
		String query = "upadet info set label=?,c_date=? ,description=? where nodeid=?";

		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, infoVo.getLabel());
			pst.setString(2, infoVo.getCreationDate());
			pst.setString(3, infoVo.getDescription());
			pst.setInt(4, infoVo.getNodeId());
			return pst.execute() ? 1 : 0;

		} catch (SQLException e) {
			LOGGER.error("Error while inserting Node data", e);
			throw new GenericException("NodeDaoImpl",
					"Error while inserting Node data", e);
		} finally {
			DBUtil.close(null, pst, con);
		}
	}

	@Ignore
	@Override
	public void deleteInfoByInfoId(int infoId) throws GenericException {

		Connection con = null;
		PreparedStatement pst = null;
		String query = "delete from info  where infoid=?";

		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(query);
			pst.setInt(1, infoId);
			pst.execute();

		} catch (SQLException e) {
			LOGGER.error("Error while inserting Node data", e);
			throw new GenericException("NodeDaoImpl",
					"Error while inserting Node data", e);
		} finally {
			DBUtil.close(null, pst, con);
		}
	}

	@Ignore
	@Override
	public void deleteInfoByNodeId(int nodeId) throws GenericException {
		Connection con = null;
		PreparedStatement pst = null;
		String query = "delete from node  where nodeId=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(query);
			pst.setInt(1, nodeId);
			pst.execute();

		} catch (SQLException e) {
			LOGGER.error("Error while inserting Node data", e);
			throw new GenericException("InfoDaoImpl",
					"Error while inserting Node data", e);
		} finally {
			DBUtil.close(null, pst, con);
		}
	}

	@Override
	public List<InfoVo> getAllInfo() throws GenericException {
		List<InfoVo> result = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query = "select * from info";

		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			if (rs != null) {
				while(rs.next()) {
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
			LOGGER.error("Error while inserting Node data", e);
			throw new GenericException("NodeDaoImpl",
					"Error while inserting Node data", e);
		} finally {
			DBUtil.close(rs, pst, con);
		}
	}

	@Override
	public void deleteAllInfo() throws GenericException {
		Connection con = null;
		String query = "delete from info ";
		try {
			con = DBUtil.getConnection();
			PreparedStatement prepst = null;
			prepst = con.prepareStatement(query);
			prepst.execute();
		} catch (SQLException e) {
			LOGGER.error("Error while inserting Node data", e);
			throw new GenericException("InfoDaoImpl",
					"Error while inserting Node data", e);
		} finally {
			DBUtil.close(null, null, con);
		}
	}

	@Override
	public int generateInfoId() throws GenericException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query = "select max(infoId) from info";
		int infoId = 1;
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();

			if (rs != null)
				if (rs.next()) {
					infoId = rs.getInt(1);
				}

		} catch (SQLException e) {
			LOGGER.error("Error while inserting Node data", e);
			throw new GenericException("InfoDaoImpl",
					"Error while inserting Node data", e);
		} finally {
			DBUtil.close(null, null, con);
		}

		return infoId+1;
	}

}
