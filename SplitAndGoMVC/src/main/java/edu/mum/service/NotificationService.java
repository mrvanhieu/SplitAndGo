package edu.mum.service;

import java.util.List;

import edu.mum.domain.Notification;

public interface NotificationService {
	
	public void save(Notification notification);

	public List<Notification> findAll();

	public Notification findOne(Long id);

}
