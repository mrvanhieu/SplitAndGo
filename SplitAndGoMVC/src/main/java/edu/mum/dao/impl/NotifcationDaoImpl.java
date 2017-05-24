package edu.mum.dao.impl;

import edu.mum.dao.NotificationDao;
import edu.mum.domain.Notification;

public class NotifcationDaoImpl extends GenericDaoImpl<Notification> implements NotificationDao {

	public NotifcationDaoImpl() {
		super.setDaoType(Notification.class);
	}
}
