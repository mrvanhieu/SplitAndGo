package edu.mum.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class NotificationServiceAspect {
	
	@Pointcut("@annotation(edu.mum.annotation.Notification)")
	public void sendNotification(){}
	
	@Pointcut("within(edu.mum.rest..*)")
	public void restService(){}
	
	@Pointcut("within(edu.mum.service..*)")
	public void mvcService(){}

}
