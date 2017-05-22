package edu.mum.service;

import java.util.List;

import edu.mum.domain.Payment;

public interface PaymentService {

	public void save(Payment payment);

	public List<Payment> findAll();

	public Payment findOne(Long id);

}
