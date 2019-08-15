package com.xugu.owl.dao;

import java.util.List;

import com.xugu.owl.model.ConnectNode;

public interface ConnectNodeDao extends BaseDao<ConnectNode>{
	
	List<ConnectNode> findByClusterId(int clusterId);
	
	int addList(List<ConnectNode> nodes);
}
