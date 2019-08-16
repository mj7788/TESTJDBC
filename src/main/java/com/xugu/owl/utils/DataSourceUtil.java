package com.xugu.owl.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.xugu.owl.model.ConnectNode;
import com.xugu.owl.properties.DruidProperties;
import com.xugu.owl.vo.Cluster;

@Component
public class DataSourceUtil {
	
	@Autowired
	private DruidProperties pro;
	
	@Autowired
	private static DruidProperties staicPro;

	public static ConcurrentHashMap<Integer, DataSource> dataSources = new ConcurrentHashMap<>();
	
	private static Logger log = LoggerFactory.getLogger(DataSourceUtil.class);

	private static String url = "jdbc:xugu://%s:%d/system%s";
	
	@PostConstruct
	public void init() {
		staicPro = pro;
	}
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
		Map<String, String> map = staicPro.getMap();
		map.put("url", getUrl(cluster.getNode()));
		DataSource dataSource = null;
		try {
			dataSource = DruidDataSourceFactory.createDataSource(staicPro.getMap());
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
				log.error("获取连接失败,集群号："+clusterId);
			}
		} 
		return con;
	}
	
	public static void close(ResultSet rs,Statement st,Connection con) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(st != null) {
			try {
				st.close();
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
	/**
	 * 执行搜集sql
	 * @param clusterId
	 * @param sql
	 * @return
	 */
	public static List<Map<String, Object>> executeQuery(int clusterId,String sql){
		Connection con = getConnection(clusterId);
		Statement st = null;
		ResultSet rs = null;
		if(con == null) 
			return null;
		else { 
			List<Map<String, Object>> datas = new ArrayList<>();
			try {
				st = con.createStatement();
				rs = st.executeQuery(sql);
				ResultSetMetaData metaData = rs.getMetaData();
				int count = metaData.getColumnCount();
				while(rs.next()) {
					Map<String, Object> data = new HashMap<>();
					for(int i = 1; i <= count; i++) {
						String columnName = metaData.getColumnName(i);
						//如果有别名 则取别名
						if(metaData.getColumnLabel(i) != null) {
							columnName = metaData.getColumnLabel(i);
						}
						data.put(columnName, rs.getObject(i));
					}
					data.put("clusterId", clusterId);
					datas.add(data);
				}
				return datas;
			} catch (SQLException e) {
				log.error("收集信息异常，集群号:{}，执行sql:{}，失败原因：{}",clusterId,sql,e.getMessage());
				return null;
			} finally {
				close(rs, st, con);
			}
		}
	}
}
  
        