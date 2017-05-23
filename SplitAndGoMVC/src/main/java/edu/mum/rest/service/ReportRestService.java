package edu.mum.rest.service;

import edu.mum.domain.Payment;

import java.util.List;

public interface ReportRestService {
    List<Payment> findPaymentsForReport(String date);
}
