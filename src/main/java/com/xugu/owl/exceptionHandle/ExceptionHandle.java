package com.xugu.owl.exceptionHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.xugu.owl.enums.ExceptionEnum;
import com.xugu.owl.exception.GlobleException;
import com.xugu.owl.model.Result;
import com.xugu.owl.utils.ResultUtil;

@RestControllerAdvice
public class ExceptionHandle {
	
	private static final Logger log = LoggerFactory.getLogger(ExceptionHandle.class);

	
	@ExceptionHandler(Exception.class)
	public Result handle(Exception e) {
		if(e instanceof GlobleException) {
			return ResultUtil.error((GlobleException)e);
		} else if (e instanceof BindException){
			return ResultUtil.error(1000,((BindException)e).getBindingResult().getAllErrors().get(0).getDefaultMessage());
		} else {
			log.error("【系统异常】{}",e);
			return ResultUtil.error(ExceptionEnum.UNKOWN_ERROR);
		}
		
	}
}
