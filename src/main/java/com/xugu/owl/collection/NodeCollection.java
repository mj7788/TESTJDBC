package com.xugu.owl.collection;

import java.sql.Connection;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xugu.owl.properties.QuerySqlProperties;
import com.xugu.owl.utils.DataSourceUtil;

@Component
public class NodeCollection {
	
	@Autowired
	QuerySqlProperties sqlPro;
	
	public void getSessionCount(int clusterId){
		String sql = sqlPro.getMap().get("session");
		Connection con = DataSourceUtil.getConnection(clusterId);
		
	}
}
  
        