package edu.mum.dao;

import java.util.List;

import edu.mum.domain.Payment;

public interface PaymentDao extends GenericDao<Payment> {

	public List<Payment> findByTripId(Long id);
    public List<Payment> findPaymentsForReport(Long id);
}
