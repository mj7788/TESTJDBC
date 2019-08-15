package com.xugu.owl.enums;


public enum WarningTypeEnum {
	
    NODE("节点异常"),
    TRANS("事务异常"),
    TABLESPACE("表空间异常");
	
	private String value;
	
    private WarningTypeEnum(String value) {
	  this.value = value;
    }
    
    public String getValue() {
    	return this.value;
    }
}
