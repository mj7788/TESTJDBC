package com.xugu.owl.model;

import javax.validation.constraints.NotBlank;

public class IgnoreNode {

	private int id;
	
	@NotBlank
	private Integer nodeId;
	
	@NotBlank
	private int clusterId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getNodeId() {
		return nodeId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	public int getClusterId() {
		return clusterId;
	}

	public void setClusterId(int clusterId) {
		this.clusterId = clusterId;
	}
	
}
