/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knowledge.store.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author KRISHNA
 */
public class NodeDataVo {
  
    private SimpleIntegerProperty nodeId;
    private SimpleIntegerProperty parentId;
    private  SimpleStringProperty label;
    private boolean isLeaf;

    public NodeDataVo(Integer nodeId, Integer parentId, String label, boolean isLeaf) {
        this.nodeId = new SimpleIntegerProperty(nodeId);
        this.parentId = new SimpleIntegerProperty(parentId);
        this.label = new SimpleStringProperty(label);
        this.isLeaf = isLeaf;
    }

    public Integer getNodeId() {
        return nodeId.getValue();
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = new SimpleIntegerProperty(nodeId);
    }

    public Integer getParentId() {
        return parentId.getValue();
    }

    public void setParentId(Integer parentId) {
        this.parentId = new SimpleIntegerProperty(parentId);
    }

    public String getLabel() {
        return label.getValue();
    }

    public void setLabel(String label) {
        this.label = new SimpleStringProperty(label);
    }

    public boolean isIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

	@Override
	public String toString() {
		return  getLabel();
	}

	
   
    
    
    
}
