package com.xugu.owl.collection;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xugu.owl.properties.QuerySqlProperties;
import com.xugu.owl.utils.DataSourceUtil;

@Component
public class NodeCollection {
	
	@Autowired
	private QuerySqlProperties sqlPro;
	
//	@Autowired
//	private 
//	
	
	public void getSessionCount(int clusterId) throws JsonProcessingException{
		String sql = sqlPro.getMap().get("session");
		List<Map<String, Object>> datas = DataSourceUtil.executeQuery(clusterId, sql);
	}
}
  
        