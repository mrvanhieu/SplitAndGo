package edu.mum.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import edu.mum.domain.Member;
import org.springframework.stereotype.Repository;

import edu.mum.dao.PaymentDao;
import edu.mum.domain.Payment;

@SuppressWarnings("unchecked")
@Repository
public class PaymentDaoImpl extends GenericDaoImpl<Payment> implements PaymentDao {

	public PaymentDaoImpl() {
		super.setDaoType(Payment.class);
	}

	public List<Payment> findByTripId(Long tripId) {
		Query query = entityManager.createQuery("select p from Payment p where p.trip.id = :tripId");
		query.setParameter("tripId", tripId);
		return query.getResultList();
	}

	@Override
	public List<Payment> findPaymentsForReport(Long tripId){
		Query query = entityManager.createQuery("SELECT  distinct trip.id as trip, date as date from Payment where trip.id="+tripId);


		List<Payment> paymentList = new ArrayList<>();
		List<Object[]> queryResultList =query.getResultList();;

		for(Object[] item: queryResultList){
			Long id = (Long)item[0];
			Date date = (java.util.Date)item[1];
			Payment payment = new Payment();
			payment.setId(id);
			payment.setDate(date);
			paymentList.add(payment);
		}

		return paymentList;
	}
}