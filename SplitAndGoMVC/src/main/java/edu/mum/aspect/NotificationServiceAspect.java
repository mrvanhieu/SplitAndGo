package edu.mum.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import edu.mum.amqp.NotificationMessageService;
import edu.mum.domain.Notification;
import edu.mum.domain.Payment;

@Aspect
public class NotificationServiceAspect {

	@Autowired
	NotificationMessageService notificationService;

	@Autowired
	RabbitTemplate directTemplate;

	@Pointcut("@annotation(edu.mum.annotation.Notification)")
	public void withAnnotation() {
	}

	@Pointcut("within(edu.mum.rest..*)")
	public void restService() {
	}

	@Pointcut("within(edu.mum.service..*)")
	public void mvcService() {
	}

	@Pointcut("args(payment)")
	public void withArgs(Payment payment) {
	}

	@AfterReturning("withAnnotation() && restService() && mvcService && withArgs(payment)")
	public void sendNotification(JoinPoint joinpoint, Payment payment) {
		// Get user name
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		// Send message to queue
		Notification notification = new Notification();
		String methodInvoke = joinpoint.getSignature().getName();
		notification.setUserName(userName);
		notification.setAction(methodInvoke);
		notification.setDescription(buildNotificationDescription(payment));
		try {
			notificationService.publish(directTemplate, notification);
		} catch (RuntimeException exception) {
			exception.printStackTrace();
		}
	}

	private String buildNotificationDescription(Payment payment) {
		return "Trip Id: " + payment.getTrip().getId() + " Date: " + payment.getDate().toString() + " Payment Amout :"
				+ payment.getAmount() + " for " + payment.getDescription() + "\r\n";
	}
}
