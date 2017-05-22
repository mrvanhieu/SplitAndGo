package edu.mum.controller;

import edu.mum.domain.Payment;
import edu.mum.service.PaymentService;
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
import java.util.Locale;

@Controller
@RequestMapping({"/payments"})
public class PaymentController {

	@Autowired
	MessageSource messageSource;

	@Autowired
	private PaymentService paymentService;

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
		return "addPayment";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewPaymentForm(@ModelAttribute("newPayment") @Valid Payment paymentToBeAdded, BindingResult result) {

		if(result.hasErrors()) {
			return "addPayment";
		}

		paymentService.save(paymentToBeAdded);

		return "redirect:/payments";
	}
}
