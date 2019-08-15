package com.xugu.owl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.xugu.owl.dao.ClusterInfoDao;
import com.xugu.owl.dao.ConnectNodeDao;
import com.xugu.owl.model.ClusterInfo;
import com.xugu.owl.model.ConnectNode;
import com.xugu.owl.utils.DataSourceUtil;
import com.xugu.owl.vo.Cluster;

public class ClusterService {

	@Autowired
	private ClusterInfoDao clusterInfoDao;
	
	@Autowired
	private ConnectNodeDao connectNodeDao;
	
	@Transactional
	public void addCluster(Cluster cluster) {
		ClusterInfo clusterInfo = cluster.getClusterInfo();
		List<ConnectNode> connectNodes = cluster.getNode();
		
		clusterInfoDao.add(clusterInfo);
		if(connectNodes.size()>0) {
			connectNodeDao.addList(connectNodes);
			if(clusterInfo.getStatus() == 0 ) {
				//初始化连接池
				DataSourceUtil.putDataSource(cluster);
	        	//启动监控
	        }
		    
		}
        
	}
	
}
