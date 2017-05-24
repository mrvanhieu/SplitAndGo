package edu.mum.amqp;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.domain.Notification;
import edu.mum.domain.NotificationMessage;
import edu.mum.service.NotificationService;

public class NotificationListener {

	@Autowired
	private NotificationService notificationService;

	public void listen(NotificationMessage notification) {
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
