package edu.mum.service;

import java.util.List;

import edu.mum.domain.Payment;

public interface PaymentService {

	public void save(Payment payment);

	public Payment update(Payment payment);

	public void delete(Long id);

	public List<Payment> findAll();

	public Payment findOne(Long id);

	public List<Payment> findByTripId(Long tripId);

}
