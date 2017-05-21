package edu.mum.dao.impl;

import org.springframework.stereotype.Repository;

import edu.mum.dao.PaymentDao;
import edu.mum.domain.Payment;

@SuppressWarnings("unchecked")
@Repository
public class PaymentDaoImpl extends GenericDaoImpl<Payment> implements PaymentDao {

	public PaymentDaoImpl() {
		super.setDaoType(Payment.class);
	}

}