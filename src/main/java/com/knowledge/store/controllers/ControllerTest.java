package com.knowledge.store.controllers;

import java.util.List;

import org.junit.Test;

import com.knowledge.store.model.NodeDataVo;

import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class ControllerTest {
	
	@FXML
	private TreeView<NodeDataVo> treeView;
	
	@Test
	public void concteteTest(){
		HomeController con = new HomeController();

		List<NodeDataVo> nodeDataList = UIUtil.nodeVOToNodeDataVO();
		for (NodeDataVo nodeDataVo : nodeDataList) {
			System.out.println("nodeDataVO in HomeController: " + nodeDataVo.getLabel());
		}

		@SuppressWarnings("restriction")
		TreeItem<NodeDataVo> root = con.constructTree(nodeDataList);
		if (root != null)
			treeView.setRoot(root);
	}
		
		
	}
	