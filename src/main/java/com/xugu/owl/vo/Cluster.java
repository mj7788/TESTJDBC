package com.xugu.owl.vo;

import java.util.List;

import javax.validation.Valid;

import com.xugu.owl.model.ClusterInfo;
import com.xugu.owl.model.ConnectNode;

public class Cluster {

	@Valid
	private ClusterInfo clusterInfo;
	
	@Valid 
	private List<ConnectNode> node;

	public ClusterInfo getClusterInfo() {
		return clusterInfo;
	}

	public void setClusterInfo(ClusterInfo clusterInfo) {
		this.clusterInfo = clusterInfo;
	}

	public List<ConnectNode> getNode() {
		return node;
	}

	public void setNode(List<ConnectNode> node) {
		this.node = node;
	}
	
}
