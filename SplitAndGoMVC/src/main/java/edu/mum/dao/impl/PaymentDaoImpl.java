package edu.mum.dao.impl;

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
	public List<Payment> findPaymentsForReport(){
		Query query = entityManager.createQuery("SELECT  distinct trip.id as trip, date as date from Payment");
		return (List<Payment>) query.getResultList();
	}
}