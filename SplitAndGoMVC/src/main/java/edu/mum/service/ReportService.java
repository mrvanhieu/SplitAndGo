package edu.mum.service;

import edu.mum.domain.Payment;

import javax.xml.ws.Response;
import java.util.List;

public interface ReportService {

	List<Payment> findPaymentsForReport(Long id);
    byte[] findPaymentsForReport(Long id, String date);
}
