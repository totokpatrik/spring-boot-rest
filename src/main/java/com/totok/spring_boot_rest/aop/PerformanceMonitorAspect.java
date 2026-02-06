package com.totok.spring_boot_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {

	private static final Logger logger = LoggerFactory.getLogger(PerformanceMonitorAspect.class);
	@Around("execution(* com.totok.spring_boot_rest.service.*.GetAllJobs(..))")
	public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
		
		long start = System.currentTimeMillis();
		
		Object obj = jp.proceed();
		
		long end = System.currentTimeMillis();
		
		
		logger.info("Time taken: " + (end - start) + " ms");
		
		return obj;
	}
	
}
