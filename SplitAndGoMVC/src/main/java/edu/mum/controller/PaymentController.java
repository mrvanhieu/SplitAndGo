package edu.mum.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Payment;
import edu.mum.domain.Trip;
import edu.mum.service.PaymentService;
import edu.mum.service.TripService;

@Controller
@RequestMapping({"/payments"})
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private TripService tripService;

	@RequestMapping("/trips")
	public String getTripsForPaymentDisplay(Model model) {
		// TODO: get available list based on login user
		model.addAttribute("trips", tripService.findAll());
		return "payment/payments";
	}
	
	@RequestMapping("/paymentsDetail/{tripId}")
	public String getPaymentsDetail(@PathVariable("tripId") Long tripId, Model model) {
		model.addAttribute("payments", paymentService.findByTripId(tripId));
		return "payment/paymentsDetail";
	}
	
	@RequestMapping
	public String listPayments(Model model) {
		model.addAttribute("payments", paymentService.findAll());
		return "payments";
	}

	@RequestMapping("/{id}")
	public String getPaymentById(@PathVariable("id") Long id,Model model, Locale locale) {
		Payment payment = paymentService.findOne(id);
		model.addAttribute("payment", payment);

		return "payment";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewPaymentForm(@ModelAttribute("newPayment") Payment newPayment) {
		return "payment/addPayment";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewPaymentForm(@ModelAttribute("newPayment") @Valid Payment paymentToBeAdded, BindingResult result) {

		if(result.hasErrors()) {
			return "payment/addPayment";
		}
		paymentService.update(paymentToBeAdded);
		
		return "payment/payments";
	}
	
	@RequestMapping("/edit/{id}")
	public String editPayment(Model model, @PathVariable("id") Long id) {
		model.addAttribute("payment", paymentService.findOne(id));
		return "payment/editPayment";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editPayment(@ModelAttribute("payment") @Valid Payment payment, BindingResult result) {
		if (result.hasErrors()) {
			return "payment/editPayment";
		}
		Trip trip = tripService.findOne(payment.getTrip().getId());
		payment.setTrip(trip);
		paymentService.update(payment);
		return "redirect:/payments/trips";
	}
	
	@RequestMapping(value = "/delete/{id}") 
	public String deletePayment(@PathVariable("id") Long paymentId) {
		paymentService.delete(paymentId);
		return "redirect:/payments/trips";
	}
	
}
