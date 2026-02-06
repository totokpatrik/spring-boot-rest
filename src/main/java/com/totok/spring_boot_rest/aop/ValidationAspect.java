package com.totok.spring_boot_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(ValidationAspect.class);
	
	@Around("execution(* com.totok.spring_boot_rest.service.*.GetJob(..)) && args(postId)")
	public Object validateAndUpdate(ProceedingJoinPoint jp, int postId) throws Throwable {
		
		if (postId < 0) {
			logger.info("postId is negative");
			postId = -postId;
			logger.info("new value " + postId);
		}
		
		Object obj = jp.proceed(new Object[] {postId});
		
		return obj;
	}

}
