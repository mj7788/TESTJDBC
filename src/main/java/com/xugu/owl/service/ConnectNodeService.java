package com.xugu.owl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xugu.owl.dao.ConnectNodeDao;
import com.xugu.owl.model.ConnectNode;

@Service 
public class ConnectNodeService {

	@Autowired
	ConnectNodeDao cnd;
	
	public void add(ConnectNode node) {
		cnd.add(node);
	} 
	
	public void delete(int id) {
		cnd.delete(id);
	}
	
	public List<ConnectNode> listAll(int clusterId) {
		return cnd.findByClusterId(clusterId);
	}
	
	public void update(ConnectNode node) {
		cnd.update(node);
	}

}
