package com.totok.spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	// return type, class-name.method name(arguments)
	
	//@Aspect - this is the aspect
	//@Before - this is the advice
	//inside the before's bracket is the point cut - expression to specify when to execute
	
	@Before("execution(* com.totok.spring_boot_rest.service.*.GetAllJobs(..)) || execution(* com.totok.spring_boot_rest.service.*.GetJob(..))")
	public void logMethodCall(JoinPoint jp) {
		//System.out.println("Method called");
		logger.info("Method called before " + jp.getSignature().getName());
	}
	
	@After("execution(* com.totok.spring_boot_rest.service.*.GetAllJobs(..)) || execution(* com.totok.spring_boot_rest.service.*.GetJob(..))")
	public void logMethodCallAfter(JoinPoint jp) {
		//System.out.println("Method called");
		logger.info("Method called after " + jp.getSignature().getName());
	}
	
	@AfterThrowing("execution(* com.totok.spring_boot_rest.service.*.GetAllJobs(..)) || execution(* com.totok.spring_boot_rest.service.*.GetJob(..))")
	public void logMethodCallCrash(JoinPoint jp) {
		//System.out.println("Method called");
		logger.info("Method called crashing " + jp.getSignature().getName());
	}

}