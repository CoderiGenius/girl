package com.imooc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
	private final static org.slf4j.Logger logger= LoggerFactory.getLogger(HttpAspect.class);

	@Pointcut("execution(public * com.imooc.controller.GirlController.*(..))")
	public void log(){
	}

	@Before("log()")
	public void doBefore(JoinPoint joinPoint){
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest httpServletRequest = attributes.getRequest();
		//url
		logger.info("url={}",httpServletRequest.getRequestURL());
		//method
		logger.info("method={}",httpServletRequest.getMethod());
		//ip
		logger.info("ip={}",httpServletRequest.getRemoteAddr());
		//classmethod
		logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
		//参数
		logger.info("args={}",joinPoint.getArgs());
	}
	@After("log()")
	public void doAfter(){
		logger.info("222222222");
	}

	@AfterReturning(returning = "object", pointcut = "log()")
	public void doAfterReturning(Object object){
		logger.info("response={}",object);
	}
}
