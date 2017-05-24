package edu.mum.dao.impl;

import org.springframework.stereotype.Repository;

import edu.mum.dao.NotificationDao;
import edu.mum.domain.Notification;

@Repository
public class NotifcationDaoImpl extends GenericDaoImpl<Notification> implements NotificationDao {

	public NotifcationDaoImpl() {
		super.setDaoType(Notification.class);
	}
}
