package com.xugu.owl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xugu.owl.dao.ClusterInfoDao;
import com.xugu.owl.model.ClusterInfo;

@Service
public class ClusterInfoService {
	
	@Autowired
	private ClusterInfoDao clusterInfoDao;
	
	public int  addCluster(ClusterInfo cluster) {
		return clusterInfoDao.add(cluster);
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
