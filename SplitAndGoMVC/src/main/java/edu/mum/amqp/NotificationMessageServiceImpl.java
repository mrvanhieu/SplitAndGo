package edu.mum.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import edu.mum.domain.NotificationMessage;

public class NotificationMessageServiceImpl implements NotificationMessageService {

	@Override
	public void publish(RabbitTemplate rabbitTemplate, NotificationMessage notification) {
		// TODO Auto-generated method stub
		rabbitTemplate.convertAndSend(notification);

	}

}
