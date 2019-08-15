package com.xugu.owl.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xugu.owl.collection.Cache;
import com.xugu.owl.model.ConnectNode;

public class ConnectionUtil {
	
	private static Logger log = LoggerFactory.getLogger(ConnectionUtil.class);

	public static final String url = "jdbc:xugu://%s:%d/system%s";
	
	public static Connection getConnection(int clusterId) {
		String url = Cache.clusters.get(clusterId);
		Connection con = null;
		if(url != null)
			try {
				con = DriverManager.getConnection(url);
			} catch (SQLException e) {
				log.error("获取集群连接失败，集群号"+clusterId);
			}
		return con;
	}
	
	
	public static String getUrl(List<ConnectNode> nodes) {
		StringBuffer ips = new StringBuffer();
		String ip = null; 
		int port = 5138;
		for(int i = 0; i < nodes.size(); i++) {
			if(i == 0) {
				ip = nodes.get(i).getIp();
				port = nodes.get(i).getPort();
			}else if (i == 1) {
				ips.append("?ips=").append(nodes.get(i).getIp());
			}else {
				ips.append(",").append(nodes.get(i).getIp());
			}
		}
		return String.format(url, ip, port, ips.toString());
	}
	
	public static void closeConnection(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			log.error("关闭连接失败");      
		}
	}
}
