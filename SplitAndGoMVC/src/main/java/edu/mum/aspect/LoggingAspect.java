package edu.mum.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import edu.mum.domain.Member;
import edu.mum.domain.Payment;
import edu.mum.domain.Trip;

@Aspect
@Component
public class LoggingAspect {

	final Logger LOG = Logger.getLogger(LoggingAspect.class);

	@Pointcut("execution(* edu.mum.service..*(..))")
	public void loggingMethod() {
	}

	@Pointcut("args(object)")
	public void loggingArgs(Object object) {
	}

	@Pointcut("@annotation(edu.mum.annotation.Logging)")
	public void logging() {
	}

	@Before("loggingMethod() && loggingArgs(object) && logging()")
	public void logInfo(JoinPoint joinPoint, Object object) {
		LOG.warn(joinPoint.toString());

		if (object instanceof Trip) {
			Trip trip = (Trip) object;
			LOG.warn(trip.getId() + " - " + trip.getName() + " - " + trip.getDescription() + " - " + trip.getStartDate()
					+ " - " + trip.getEndDate() + " - " + trip.getDuration() + " - " + trip.getFund().getTotalAmount());
		} else if (object instanceof Payment) {
			Payment payment = (Payment) object;
			LOG.warn(payment.getId() + " - " + payment.getDescription() + " - " + payment.getDate() + " - "
					+ payment.getAmount());
		} else if (object instanceof Member) {
			Member member = (Member) object;
			LOG.warn(member.getId() + " - " + member.getFirstName() + " " + member.getLastName() + " - "
					+ member.getEmail() + " - " + member.getPhone());
		} else if (object instanceof Long) {
			Long id = (Long) object;
			LOG.warn(id);
		}
	}
}
