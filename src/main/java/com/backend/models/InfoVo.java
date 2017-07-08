package com.backend.models;

public class InfoVo {
	
	Integer id;

	Integer nodeId;

	String creationDate;
	
	String label;
	
	String description;
	
	
	public InfoVo() {
		super();
	}
	public InfoVo(Integer id, Integer nodeId, String creationDate, String label, String description) {
		super();
		this.id = id;
		this.nodeId = nodeId;
		this.creationDate = creationDate;
		this.label = label;
		this.description = description;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNodeId() {
		return nodeId;
	}
	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

	@Override
	public String toString() {
		return "InfoVo [id=" + id + ", nodeId=" + nodeId + ", creationDate=" + creationDate + ", label=" + label
				+ ", description=" + description + "]";
	}
}
