package edu.mum.service;

import java.util.List;

import edu.mum.domain.Payment;
import edu.mum.domain.dto.PaymentDto;

public interface PaymentService {

	public void save(Payment payment);
	
	public PaymentDto update(PaymentDto payment);
	
	public void delete(Long id);

	public List<Payment> findAll();

	public PaymentDto findOne(Long id);
	
	public List<PaymentDto> findByTripId(Long id);

}
