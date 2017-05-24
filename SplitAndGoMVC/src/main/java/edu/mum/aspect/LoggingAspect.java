package edu.mum.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	final Logger LOG = LoggerFactory.getLogger(LoggingAspect.class);
			
	@Pointcut("execution(* edu.mum.service..*(..))")
	public void loggingMethod() {
	}

	@Pointcut("args(Object)")
	public void loggingArgs() {
	}

	@Pointcut("@annotation(edu.mum.annotation.Logging)")
	public void logging() {
	}
	
	@Before("loggingMethod() && logging() && logging()")
	public void logInfo(JoinPoint joinPoint) {
		LOG.info(joinPoint.getSignature().getName());
		System.out.println(joinPoint.getSignature().getName());
	}
}
