package edu.mum.service.impl;

import edu.mum.dao.PaymentDao;
import edu.mum.domain.Payment;
import edu.mum.rest.service.PaymentRestService;
import edu.mum.rest.service.ReportRestService;
import edu.mum.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

//	public void save(Payment payment) {
//		paymentRestService.save(payment);
//	}
//
//	public List<Payment> findAll() {
//		return (List<Payment>) paymentRestService.findAll();
//	}
//
//	public Payment findOne(Long id) {
//		return paymentRestService.findOne(id);
//	}

	@Autowired
	private PaymentDao paymentDao;

	@Autowired
	private PaymentRestService paymentRestService;

	@Autowired
	private ReportRestService reportRestService;

	public void save(Payment payment) {
		paymentRestService.save(payment);
	}

	public Payment update(Payment payment) {
		return paymentRestService.update(payment);
	}

	public void delete(Long id) {
		paymentDao.delete(id);
	}

	public List<Payment> findAll() {
		return (List<Payment>) paymentRestService.findAll();
	}

	public Payment findOne(Long id) {
		return paymentRestService.findOne(id);
	}

	public List<Payment> findByTripId(Long tripId) {
		return paymentDao.findByTripId(tripId);
	}

}
