package edu.mum.rest.service;

import edu.mum.domain.Payment;

import javax.xml.ws.Response;
import java.util.List;

public interface ReportRestService {
    byte[] findPaymentsForReport(Long id, String date);
}
