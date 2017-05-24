package edu.mum.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import edu.mum.amqp.NotificationMessageService;
import edu.mum.amqp.NotificationMessageServiceImpl;
import edu.mum.domain.NotificationMessage;
import edu.mum.domain.Payment;
import edu.mum.domain.Trip;
import edu.mum.domain.dto.PaymentDto;

@Aspect
@Component
public class NotificationServiceAspect {

	private NotificationMessageService notificationService;

	@Autowired
	RabbitTemplate directTemplate;

	@Pointcut("@annotation(edu.mum.annotation.Notification)")
	public void withAnnotation() {
	}

	@Pointcut("execution(* edu.mum.service..*(..))")
	public void serviceMethod() {
	}

	// @Pointcut("within(edu.mum.rest..*)")
	// public void restService() {
	// }

	// @Pointcut("within(edu.mum.service..*)")
	// public void mvcService() {
	// }

	@Pointcut("args(payment)")
	public void withArgs(Object payment) {
	}

	//@Before("withAnnotation() && serviceMethod() && withArgs(payment)")
	@AfterReturning("withAnnotation() && serviceMethod() && withArgs(payment)")
	public void sendNotification(JoinPoint joinpoint, Object payment) {

		Payment paymentTemp = null;
		if (payment instanceof PaymentDto) {
			paymentTemp = new Payment();
			paymentTemp.setAmount(((PaymentDto) payment).getAmount());
			paymentTemp.setDate(((PaymentDto) payment).getDate());
			paymentTemp.setDescription(((PaymentDto) payment).getDescription());
			Trip trip = new Trip();
			trip.setId(((PaymentDto) payment).getTripId());
			paymentTemp.setTrip(trip);

		}else{
			paymentTemp = (Payment) payment;
		}
		// Get user name
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		// Send message to queue
		NotificationMessage notification = new NotificationMessage();
		notificationService = new NotificationMessageServiceImpl();

		String methodInvoke = joinpoint.getSignature().getName();
		notification.setUserName(userName);
		notification.setAction(methodInvoke);
		notification.setDate(new Date());
		System.out.println(buildNotificationDescription(paymentTemp,userName,methodInvoke));
		notification.setDescription(buildNotificationDescription(paymentTemp,userName,methodInvoke));
		try {
			notificationService.publish(directTemplate, notification);
		} catch (RuntimeException exception) {
			exception.printStackTrace();
		}
	}

	private String buildNotificationDescription(Payment payment, String userName, String action) {

		String tripId = payment.getTrip().getId() != null ? String.valueOf(payment.getTrip().getId()) : " ";
		String date =  (new SimpleDateFormat ("yyyy-MM-dd")).format(payment.getDate());

		return "Trip Id: " + tripId + " Date: " + date + " " + userName.toUpperCase() + " " + action.toUpperCase()
				+ " Payment Amout :"
				+ payment.getAmount() + " for " + payment.getDescription() + "\r\n";
	}
}
