package edu.mum.rest.service;

import edu.mum.domain.Payment;

import java.util.List;

public interface PaymentRestService {

	public void save(Payment payment);
	
	public Payment update(Payment payment);

	public List<Payment> findAll();

	public Payment findOne(Long id);

}
