package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.dao.NotificationDao;
import edu.mum.domain.Notification;
import edu.mum.service.NotificationService;

public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
	private NotificationDao notificationDao;

	@Override
	public void save(Notification notification) {
		notificationDao.save(notification);
		
	}

	@Override
	public List<Notification> findAll() {
		return notificationDao.findAll();
	}

	@Override
	public Notification findOne(Long id) {
		// TODO Auto-generated method stub
		return notificationDao.findOne(id);
	}

}
