package com.xugu.owl.model;

import java.util.Date;

import com.xugu.owl.enums.WarningTypeEnum;

public class Warning {

	private int id;
	
	private Integer nodeId;
	
	private WarningTypeEnum warningType;
	
	private String detail;
	
	private String keyWord;
	
	private short resolved;
	
	private short resolvedType;
	
	private String suggestion;
	
	private Date createTime;
	
	private Date updateTime;
	
	private int clusterId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getNodeId() {
		return nodeId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	public WarningTypeEnum getWarningType() {
		return warningType;
	}

	public void setWarningType(WarningTypeEnum warningType) {
		this.warningType = warningType;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public short getResolved() {
		return resolved;
	}

	public void setResolved(short resolved) {
		this.resolved = resolved;
	}

	public short getResolvedType() {
		return resolvedType;
	}

	public void setResolvedType(short resolvedType) {
		this.resolvedType = resolvedType;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getClusterId() {
		return clusterId;
	}

	public void setClusterId(int clusterId) {
		this.clusterId = clusterId;
	}
	
}
