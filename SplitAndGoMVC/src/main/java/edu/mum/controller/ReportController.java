package edu.mum.controller;

import edu.mum.domain.Payment;
import edu.mum.service.PaymentService;
import edu.mum.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping({"/paymentReports"})
public class ReportController {

	@Autowired
	MessageSource messageSource;

	@Autowired
	private ReportService reportService;

	@RequestMapping
	public String listReports(Model model) {
		model.addAttribute("paymentReports", reportService.findPaymentsForReport());
		return "report/paymentReports";
	}

	@RequestMapping("/{date}")
	public String getReportById(@PathVariable("date") String date,Model model, Locale locale) {
		List<Payment> payments = reportService.findPaymentsForReport(date);
		model.addAttribute("paymentReports", payments);

		return "report/paymentReport";
	}
}
