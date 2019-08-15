package com.xugu.owl.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xugu.owl.utils.JsonUtil;

@Aspect
@Component
public class LogAspect {

	private static final Logger log = LoggerFactory.getLogger(LogAspect.class);
	
	private static long startTime;
	
	@Pointcut("execution(public * com.xugu.owl.controller.*.*(..))")
	public void log() {}
	
	@Before("log()")
	public void methodBefore(JoinPoint joinPoint) throws JsonProcessingException {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        
        //打印请求内容
        log.info("请求地址: {},请求方式: {},请求类方法: {},请求参数: {}",
        		request.getRequestURL().toString(),
        		request.getMethod(),
        		joinPoint.getSignature(),
        		JsonUtil.generate(joinPoint.getArgs()));
        
        startTime = System.currentTimeMillis();
	}
	
	@AfterReturning(pointcut = "log()",returning = "result")
	public void methodAfter(Object result) throws JsonProcessingException {
		log.info("请求耗时: {}ms,返回值: {}",System.currentTimeMillis() - startTime,JsonUtil.generate(result),JsonUtil.generate(result));
	}
}
