package com.backend.dao;

import java.util.List;

import com.backend.models.NodeVo;
import com.exception.GenericException;

public interface NodeDao {

	// 1: add data in node
	int addNode(NodeVo nodeData) throws GenericException;

	// 2: get node data based on node id.

	NodeVo getNodeById(int NodeId) throws GenericException;

	// 3: updateNode

	int updateNode(NodeVo nodeVo) throws GenericException;

	// 4: deleteNode with Node id

	void deleteNodeById(int nodeId) throws GenericException;

	// 5: get all list of node

	List<NodeVo> getAllNode() throws GenericException;

	// 6: delete list of nodes
	void deleteNodeByIds(List<Integer> nodeIds) throws GenericException;

	// 7:delete all node.

	void deleteAllNode() throws GenericException;

}
