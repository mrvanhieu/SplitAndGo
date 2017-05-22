package edu.mum.service.impl;

import edu.mum.domain.Payment;
import edu.mum.rest.service.PaymentRestService;
import edu.mum.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRestService paymentRestService;

	public void save(Payment payment) {
		paymentRestService.save(payment);
	}

	public List<Payment> findAll() {
		return (List<Payment>) paymentRestService.findAll();
	}

	public Payment findOne(Long id) {
		return paymentRestService.findOne(id);
	}

}
