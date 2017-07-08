/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knowledge.store.controllers;

import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

import org.controlsfx.control.textfield.TextFields;

import com.backend.dao.InfoDao;
import com.backend.dao.NodeDao;
import com.backend.dao.impl.InfoDaoImpl;
import com.backend.dao.impl.NodeDaoImpl;
import com.backend.models.InfoVo;
import com.backend.models.NodeVo;
import com.knowledge.store.model.InfoDataVo;
import com.knowledge.store.model.NodeDataVo;

/**
 *
 * @author KRISHNA
 */
public class UIUtil {

	public static TextField createClearableTextField() {
		final TextField clearableTextField = TextFields.createClearableTextField();
		clearableTextField.setMinWidth(0);
		clearableTextField.getStyleClass().add("tree-scearch-text-box");
		clearableTextField.setPromptText("Search...");
		return clearableTextField;

	}

	public static List<NodeDataVo> nodeVOToNodeDataVO(List<NodeVo> nodeVos) {
		List<NodeDataVo> nodeDataList = new ArrayList<NodeDataVo>();	
		
		for (NodeVo nodeVo : nodeVos) {
			nodeDataList.add(new NodeDataVo(nodeVo.getNodeId(), nodeVo.getParentId(), nodeVo.getLabel(),
					nodeVo.isLeaf()));

		}
		return nodeDataList;

	}
	
	public static List<NodeVo> nodeDataVOToNodeVO(List<NodeDataVo> nodeDataVos) {
		List<NodeVo> nodeVoList = new ArrayList<NodeVo>();	
		
		for (NodeDataVo nodeDataVo : nodeDataVos) {
			nodeVoList.add(new NodeVo(nodeDataVo.getNodeId(), nodeDataVo.getParentId(), nodeDataVo.getLabel(),
					nodeDataVo.isIsLeaf()));

		}
		return nodeVoList;

	}
	
	
	public static List<InfoDataVo> infoVOToInfoDataVO() {
		List<InfoDataVo> infoDataList = new ArrayList<>();

		InfoDao infoDao = new InfoDaoImpl();
		List<InfoVo> infoVo = infoDao.getAllInfo();
		for (InfoVo infoVo2 : infoVo) {
			InfoDataVo infoData = new InfoDataVo(infoVo2.getNodeId(), infoVo2.getCreationDate(), infoVo2.getLabel(),
					infoVo2.getDescription());

			infoDataList.add(infoData);

		}

		return infoDataList;

	}
	

}
