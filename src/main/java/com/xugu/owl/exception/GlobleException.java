package com.xugu.owl.exception;

import com.xugu.owl.enums.ExceptionEnum;

public class GlobleException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private int code;
	
	public GlobleException(ExceptionEnum e) {
		super(e.getMessage());
		this.code = e.getCode();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
