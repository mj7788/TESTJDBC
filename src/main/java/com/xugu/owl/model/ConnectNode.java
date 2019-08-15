package com.xugu.owl.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @ClassName ClusterNode
 * @Description 集群连接节点信息实体类
 * @author mj 
 * @date 2019年7月27日 上午10:46:11  
 * @version v1.0
 */

public class ConnectNode {
	
	private int id;
	
	@NotBlank(message="节点IP不能为空")
	@Pattern(regexp="^([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}$",message="ip格式错误")
	private String ip;
	
	@Min(value=1024,message="端口范围为1024-65535")
	@Max(value=65535,message="端口范围为1024-65535")
	private int port;
	
	private int clusterId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getClusterId() {
		return clusterId;
	}

	public void setClusterId(int clusterId) {
		this.clusterId = clusterId;
	}

}
  
        