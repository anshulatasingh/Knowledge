package com.backend.dao;

import java.util.List;

import com.backend.models.InfoVo;
import com.exception.GenericException;

public interface InfoDao {
	
	// 1: add data in node
	int addInfo(InfoVo infoData) throws GenericException;
	
	
	void addInfos(List<InfoVo> infoData) throws GenericException;

	// 2: get node data based on node id.

	InfoVo getInfoByInfoId(int infoIdId) throws GenericException;

	List<InfoVo> getInfoByNodeId(int nodeId) throws GenericException;
	
	// 3: updateNode

	int updateInfoByInfoId(InfoVo infoVo) throws GenericException;
	
	int updateInfoByNodeId(InfoVo vo) throws GenericException;

	// 4: deleteNode with Node id

	void deleteInfoByInfoId(int infoId) throws GenericException;
	
	void deleteInfoByNodeId(int infoId) throws GenericException;

	// 5: get all list of node

	List<InfoVo> getAllInfo() throws GenericException;


	// 7:delete all node.

	void deleteAllInfo() throws GenericException;
	
	int  generateInfoId( )throws GenericException;
	

}
