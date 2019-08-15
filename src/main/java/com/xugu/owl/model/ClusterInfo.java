package com.xugu.owl.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @ClassName Cluster
 * @Description 集群信息实体类
 * @author mj 
 * @date 2019年7月27日 上午10:31:37  
 * @version v1.0
 */

public class ClusterInfo {
	
	private int id;
	
	@NotBlank(message="集群名称不能为空")
	@Size(max=24,message="集群名称长度不能超过24个字符")
	private String name;
	
	/**
	 * 0为监控，1为不监控
	 */
	private int status;
	
	private String comment;
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
  
        