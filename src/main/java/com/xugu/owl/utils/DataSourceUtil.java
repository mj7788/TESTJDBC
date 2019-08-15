package com.xugu.owl.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.xugu.owl.model.ConnectNode;
import com.xugu.owl.properties.DruidProperties;
import com.xugu.owl.vo.Cluster;

public class DataSourceUtil {
	
	
	private static DruidProperties pro = new DruidProperties();

	public static ConcurrentHashMap<Integer, DataSource> dataSources = new ConcurrentHashMap<>();
	
	private static Logger log = LoggerFactory.getLogger(DataSourceUtil.class);

	private static String url = "jdbc:xugu://%s:%d/system%s";
	
	private static String getUrl(List<ConnectNode> nodes) {
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
	
	public static void putDataSource(Cluster cluster){
		Map<String, String> map = pro.getMap();
		map.put("url", getUrl(cluster.getNode()));
		DataSource dataSource = null;
		try {
			dataSource = DruidDataSourceFactory.createDataSource(pro.getMap());
		} catch (Exception e) {
			log.error("创建连接池失败,集群名称："+cluster.getClusterInfo().getName());
		}
		dataSources.put(cluster.getClusterInfo().getId(), dataSource);
	}
	
	public static Connection getConnection(int clusterId) {
		Connection con = null;
		if(dataSources.containsKey(clusterId) && dataSources.get(clusterId) != null){
			try {
				con = dataSources.get(clusterId).getConnection();
			} catch (SQLException e) {
				log.error("获取连接失败,集群编号："+clusterId);
			}
		} 
		return con;
	}
	
	public static void close(ResultSet rs,Connection con) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
  
        