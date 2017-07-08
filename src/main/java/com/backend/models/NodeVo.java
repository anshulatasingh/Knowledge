package com.backend.models;

public class NodeVo {

    Integer nodeId;
    
	Integer parentId;
	
	String label;
	
	boolean isLeaf;
	

	public NodeVo() {
		super();
	}

	public NodeVo(Integer nodeId, Integer parentId, String label, Boolean isLeaf) {
		super();
		this.nodeId = nodeId;
		this.parentId = parentId;
		this.label = label;
		this.isLeaf = isLeaf;
	}

	public Integer getNodeId() {
		return nodeId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	
	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	@Override
	public String toString() {
		return "NodeVo [nodeId=" + nodeId + ", parentId=" + parentId + ", label=" + label + ", isLeaf=" + isLeaf + "]";
	}
	

}
