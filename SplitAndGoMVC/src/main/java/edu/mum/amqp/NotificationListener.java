package edu.mum.amqp;

import edu.mum.domain.Notification;
import edu.mum.service.NotificationService;
import edu.mum.service.impl.NotificationServiceImpl;

public class NotificationListener {

	NotificationService notificationService;

	public void listen(Notification notification) {
		notificationService = new NotificationServiceImpl();
		try {
			notificationService.save(notification);
		} catch (RuntimeException ex) {
			ex.printStackTrace();
		}

	}

}
