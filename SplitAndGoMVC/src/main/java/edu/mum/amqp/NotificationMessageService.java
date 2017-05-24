package edu.mum.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import edu.mum.domain.Notification;

public interface NotificationMessageService {
	
	public void publish(RabbitTemplate rabbitTemplate, Notification notification);

}
