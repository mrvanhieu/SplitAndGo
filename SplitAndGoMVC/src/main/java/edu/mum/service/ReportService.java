package edu.mum.service;

import edu.mum.domain.Payment;

import java.util.List;

public interface ReportService {

	List<Payment> findPaymentsForReport();
	List<Payment> findPaymentsForReport(String date);
}
