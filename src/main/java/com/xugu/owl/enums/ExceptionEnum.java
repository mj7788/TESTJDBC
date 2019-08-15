package com.xugu.owl.enums;

public enum ExceptionEnum {
	
	SUCCESS(200,"请求成功"),
	UNKOWN_ERROR(-1,"服务器正忙"),
	PARAMETER_ERROR(1000,"参数验证错误"),
	;
	
	private int code;
	private String message;
	
	
	private ExceptionEnum(int code, String msg) {
		this.code = code;
		this.message = msg;
	}


	public int getCode() {
		return code;
	}


	public String getMessage() {
		return message;
	}
	
}
