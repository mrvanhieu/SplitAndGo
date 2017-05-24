package edu.mum.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import edu.mum.domain.Notification;

public class NotificationMessageServiceImpl implements NotificationMessageService {

	@Override
	public void publish(RabbitTemplate rabbitTemplate, Notification notification) {
		// TODO Auto-generated method stub
		rabbitTemplate.convertAndSend(notification);
		
	}

}
