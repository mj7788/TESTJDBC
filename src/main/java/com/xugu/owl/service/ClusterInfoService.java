package com.xugu.owl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xugu.owl.collection.NodeCollection;
import com.xugu.owl.dao.ClusterInfoDao;
import com.xugu.owl.dao.ConnectNodeDao;
import com.xugu.owl.model.ClusterInfo;
import com.xugu.owl.model.ConnectNode;
import com.xugu.owl.utils.DataSourceUtil;
import com.xugu.owl.vo.Cluster;

@Service
public class ClusterInfoService {
	
	@Autowired
	private ClusterInfoDao clusterInfoDao;
	
	@Autowired
	private ConnectNodeDao connectNodeDao;
	
	@Autowired
	private NodeCollection collection;
	
	@Transactional
	public void addCluster(Cluster cluster) {
		ClusterInfo clusterInfo = cluster.getClusterInfo();
		List<ConnectNode> connectNodes = cluster.getNode();
		
		clusterInfoDao.add(clusterInfo);
		int clusterId = clusterInfo.getId();
		if(connectNodes.size()>0) {
			connectNodes.forEach(node->node.setClusterId(clusterId));
			connectNodeDao.addList(connectNodes);
			if(clusterInfo.getStatus() == 0 ) {
				//初始化连接池
				DataSourceUtil.putDataSource(cluster);
	        	//启动监控
				try {
					collection.getSessionCount(clusterInfo.getId());
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
	        }
		}
	}
	
	public int deleteCluster(int id) {
		return clusterInfoDao.delete(id);
	}
	
	public List<ClusterInfo> listCluster(){
		return clusterInfoDao.findAll();
	}
	
	public int updateCluster(ClusterInfo cluster) {
		return clusterInfoDao.update(cluster);
	}

}
