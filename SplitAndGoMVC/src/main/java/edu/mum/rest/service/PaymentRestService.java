package edu.mum.rest.service;

import edu.mum.domain.Payment;
import edu.mum.domain.dto.PaymentDto;

import java.util.List;

public interface PaymentRestService {

	public void save(PaymentDto payment);
	
	public PaymentDto update(PaymentDto payment);
	
	public void delete(Long id);

	public List<Payment> findAll();

	public PaymentDto findOne(Long id);
	
	public List<PaymentDto> findByTripId(Long tripId);

}
