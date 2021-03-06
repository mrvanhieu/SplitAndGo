package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.annotation.Logging;
import edu.mum.annotation.Notification;
import edu.mum.domain.Payment;
import edu.mum.domain.dto.PaymentDto;
import edu.mum.rest.service.PaymentRestService;
import edu.mum.rest.service.ReportRestService;
import edu.mum.service.PaymentService;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRestService paymentRestService;

	@Autowired
	private ReportRestService reportRestService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Logging
	@Notification
	public void save(PaymentDto payment) {
		paymentRestService.save(payment);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Logging
	@Notification
	public PaymentDto update(PaymentDto payment) {
		return paymentRestService.update(payment);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Logging
	public void delete(Long id) {
		paymentRestService.delete(id);
	}

	public List<Payment> findAll() {
		return (List<Payment>) paymentRestService.findAll();
	}

	public PaymentDto findOne(Long id) {
		return paymentRestService.findOne(id);
	}

	public List<PaymentDto> findByTripId(Long tripId) {
		return paymentRestService.findByTripId(tripId);
	}

}
