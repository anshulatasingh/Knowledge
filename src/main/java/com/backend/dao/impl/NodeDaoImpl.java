package com.backend.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.backend.dao.NodeDao;
import com.backend.models.NodeVo;
import com.exception.GenericException;
import com.util.DBUtil;

public class NodeDaoImpl implements NodeDao {

	private static final Logger LOGGER = Logger.getLogger(NodeDaoImpl.class);

	@Override
	public int addNode(NodeVo nodeData) throws GenericException {

		System.out.println(nodeData.toString());
		// 1: create sql query
		// 2: get connection
		// 3: create statement
		// 4:submit the sql query to dataase
		// 5: process the result
		// 6:close the connection

		String query = "insert into node(nodeId,parentid,label,isLeaf) values(?,?,?,?)";
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(query);

			pst.setInt(1, nodeData.getNodeId());
			pst.setInt(2, nodeData.getParentId());
			pst.setString(3, nodeData.getLabel());
			pst.setBoolean(4, nodeData.isLeaf());
			return pst.execute() ? 1 : 0;
		} catch (SQLException e) {
			LOGGER.error("Error while inserting Node data", e);
			throw new GenericException("NodeDaoImpl", "Error while inserting Node data", e);
		} finally {
			DBUtil.close(null, pst, con);
		}
	}

	@Override
	public NodeVo getNodeById(int nodeId) throws GenericException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query = "select * from Node where NodeId=?";
		NodeVo vo = new NodeVo();
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(query);
			pst.setInt(1, nodeId);
			rs = pst.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					vo.setNodeId(rs.getInt("nodeId"));
					vo.setParentId(rs.getInt("parentId"));
					vo.setLabel(rs.getString("label"));
					vo.setLeaf(rs.getBoolean("isLeaf"));

				}

			}
			return vo;

		} catch (SQLException e) {
			LOGGER.error("Error while inserting Node data", e);
			throw new GenericException("NodeDaoImpl", "Error while inserting Node data", e);
		} finally {
			DBUtil.close(rs, pst, con);
		}

	}

	@Override
	public int updateNode(NodeVo nodeVO) throws GenericException {

		Connection con = null;
		PreparedStatement pst = null;
		String query = "upadet node set label=?,isLeaf=? ,parentid=? where nodeid=?";

		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, nodeVO.getLabel());
			pst.setInt(2, nodeVO.getParentId());
			pst.setBoolean(3, nodeVO.isLeaf());
			pst.setInt(4, nodeVO.getNodeId());
			return pst.execute() ? 1 : 0;

		} catch (SQLException e) {
			LOGGER.error("Error while inserting Node data", e);
			throw new GenericException("NodeDaoImpl", "Error while inserting Node data", e);
		} finally {
			DBUtil.close(null, pst, con);
		}
	}
	
	@Override
	public void deleteNodeById(int nodeId) throws GenericException {

		Connection con = null;
		PreparedStatement pst = null;
		String query = "delete from node  where nodeid=?";

		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(query);
			pst.setInt(1, nodeId);
			pst.execute();

		} catch (SQLException e) {
			LOGGER.error("Error while inserting Node data", e);
			throw new GenericException("NodeDaoImpl", "Error while inserting Node data", e);
		} finally {
			DBUtil.close(null, pst, con);
		}

	}

	@Override
	public List<NodeVo> getAllNode() throws GenericException {
		List<NodeVo> result = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query = "select * from Node";

		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					NodeVo vo = new NodeVo();
					vo.setNodeId(rs.getInt("nodeId"));
					vo.setParentId(rs.getInt("parentId"));
					vo.setLabel(rs.getString("label"));
					vo.setLeaf(rs.getBoolean("isLeaf"));
					result.add(vo);
				}

			}
			return result;

		} catch (SQLException e) {
			LOGGER.error("Error while inserting Node data", e);
			throw new GenericException("NodeDaoImpl", "Error while inserting Node data", e);
		} finally {
			DBUtil.close(rs, pst, con);
		}
	}

	@Override
	public void deleteNodeByIds(List<Integer> nodeIds) throws GenericException {
		if (nodeIds != null) {
			nodeIds.forEach(id -> deleteNodeById(id));
		}

	}

	@Override
	public void deleteAllNode() throws GenericException {

		Connection con = null;
		PreparedStatement pst = null;
		String query = "delete from node";

		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(query);
			pst.execute();

		} catch (SQLException e) {
			LOGGER.error("Error while inserting Node data", e);
			throw new GenericException("NodeDaoImpl", "Error while Deleting Node data", e);
		} finally {
			DBUtil.close(null, pst, con);
		}

	}

}
