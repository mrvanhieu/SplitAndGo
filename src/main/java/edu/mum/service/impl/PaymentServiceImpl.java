package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.PaymentDao;
import edu.mum.domain.Payment;
import edu.mum.service.PaymentService;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDao paymentDao;

	public void save(Payment payment) {
		paymentDao.save(payment);
	}

	public List<Payment> findAll() {
		return (List<Payment>) paymentDao.findAll();
	}

	public Payment findOne(Long id) {
		return paymentDao.findOne(id);
	}

}
