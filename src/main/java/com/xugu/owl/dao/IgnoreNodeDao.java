package com.xugu.owl.dao;

import java.util.List;

import com.xugu.owl.model.IgnoreNode;

public interface IgnoreNodeDao extends BaseDao<IgnoreNode>{

	List<IgnoreNode> findByClusterId(int clusterId);
}
