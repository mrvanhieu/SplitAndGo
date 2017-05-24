package edu.mum.amqp;

import edu.mum.domain.Notification;
import edu.mum.domain.NotificationMessage;
import edu.mum.service.NotificationService;
import edu.mum.service.impl.NotificationServiceImpl;

public class NotificationListener {

	private NotificationService notificationService;

	public void listen(NotificationMessage notification) {
		notificationService = new NotificationServiceImpl();
		try {
			Notification entity = new Notification();
			System.out.println(notification.getAction());
			entity.setAction(notification.getAction());
			System.out.println(notification.getAction());
			entity.setDate(notification.getDate());
			entity.setDescription(notification.getDescription());
			entity.setUserName(notification.getUserName());
			//entity.setId(notification.getId());
			
			notificationService.save(entity);
			System.out.println(notification.getUserName() + "  do  " + notification.getAction());
		} catch (RuntimeException ex) {
			ex.printStackTrace();
		}

	}

}
