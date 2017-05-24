package edu.mum.service.impl;

import edu.mum.dao.PaymentDao;
import edu.mum.dao.TripDao;
import edu.mum.domain.Payment;
import edu.mum.domain.dto.PaymentDto;
import edu.mum.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDao paymentDao;

	@Autowired
	private TripDao tripDao;
	
	public void save(Payment payment) {
		paymentDao.save(payment);
	}
	
	public PaymentDto update(PaymentDto paymentDto) {
		return buildPaymentDto(paymentDao.update(buildPayment(paymentDto)));
	}
	
	public void delete(Long id) {
		paymentDao.delete(id);
	}
	
	private Payment buildPayment(PaymentDto paymentDto) {
		Payment payment = new Payment();
		payment.setId(paymentDto.getId());
		payment.setDescription(paymentDto.getDescription());
		payment.setDate(paymentDto.getDate());
		payment.setAmount(paymentDto.getAmount());
		payment.setTrip(tripDao.findOne(paymentDto.getTripId()));
		return payment;
	}

	public List<Payment> findAll() {
		return (List<Payment>) paymentDao.findAll();
	}

	public PaymentDto findOne(Long id) {
		Payment payment = paymentDao.findOne(id); 
		return buildPaymentDto(payment);
	}
	
	public List<PaymentDto> findByTripId(Long tripId) {
		List<PaymentDto> paymentDtos = new ArrayList<>();
		for (Payment payment: paymentDao.findByTripId(tripId)) {
			paymentDtos.add(buildPaymentDto(payment));
		}
		return paymentDtos;
	}
	
	private PaymentDto buildPaymentDto(Payment payment) {
		PaymentDto paymentDto = new PaymentDto();
		paymentDto.setId(payment.getId());
		paymentDto.setDescription(payment.getDescription());
		paymentDto.setDate(payment.getDate());
		paymentDto.setAmount(payment.getAmount());
		paymentDto.setTripId(payment.getTrip().getId());
		return paymentDto;
	}

}
