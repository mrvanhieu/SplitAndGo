package edu.mum.service.impl;

import edu.mum.dao.PaymentDao;
import edu.mum.domain.Payment;
import edu.mum.rest.service.ReportRestService;
import edu.mum.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportRestService reportRestService;

	@Autowired
	private PaymentDao paymentDao;

	@Override
	public List<Payment> findPaymentsForReport(Long id) {
		return paymentDao.findPaymentsForReport(id);
	}

	@Override
	public byte[] findPaymentsForReport(Long id, String date) {
		byte[] response =reportRestService.findPaymentsForReport(id, date);;
		return response;
	}


}
