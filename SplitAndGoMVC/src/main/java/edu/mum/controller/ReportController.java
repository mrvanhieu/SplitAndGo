package edu.mum.controller;

import edu.mum.domain.Payment;
import edu.mum.service.PaymentService;
import edu.mum.service.ReportService;
import edu.mum.service.TripService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.ws.Response;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping({"/paymentReports"})
public class ReportController {

	@Autowired
	MessageSource messageSource;

	@Autowired
	private ReportService reportService;

	@Autowired
	private TripService tripService;

	@RequestMapping("/{tripId}")
	public String getTripsForPaymentDisplay(@PathVariable("tripId") Long tripId, Model model) {
		model.addAttribute("paymentReports", reportService.findPaymentsForReport(tripId));
		return "report/paymentReportsDetail";
	}


	@RequestMapping
	public String listReports(Model model) {
		model.addAttribute("trips", tripService.findAll());
		return "report/paymentReports";
	}

	@RequestMapping("/{id}/{date}")
	@ResponseBody
	public void getReportById(@PathVariable("id") Long id, @PathVariable("date") String date, Model model, Locale locale, HttpServletResponse response) {
		byte[] content = reportService.findPaymentsForReport(id, date);
		try {
			// copy it to response's OutputStream
			IOUtils.copy(new ByteArrayInputStream(content), response.getOutputStream());
			response.flushBuffer();
		} catch (IOException ex) {
			System.out.println("Error writing file to output stream");
			throw new RuntimeException("IOError writing file to output stream");
		}
	}
}
