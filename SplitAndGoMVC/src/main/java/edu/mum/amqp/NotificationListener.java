package edu.mum.amqp;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.domain.Notification;
import edu.mum.service.NotificationService;

public class NotificationListener {

	@Autowired
	NotificationService notificationService;

	public void listen(Notification notification) {

		try {
			notificationService.save(notification);
		} catch (RuntimeException ex) {
			ex.printStackTrace();
		}

	}

}
