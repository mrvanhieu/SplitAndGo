package edu.mum.rest.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.domain.Payment;
import edu.mum.domain.dto.PaymentDto;
import edu.mum.service.PaymentService;
import edu.mum.service.TripService;

@Component
@Path("/payments")
public class PaymentRestService {

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private TripService tripService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Payment> getPayments() {
		return paymentService.findAll();
	}

	@GET
	@Path("{id: \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public PaymentDto getPaymentById(@PathParam("id") Long id) {
		return paymentService.findOne(id);
	}
	
	@GET
	@Path("trip/{id: \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PaymentDto> getPaymentsByTripId(@PathParam("id") Long id) {
		return paymentService.findByTripId(id);
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(MediaType.APPLICATION_JSON)
	public void savePayment(PaymentDto payment) {
		paymentService.update(payment);
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(MediaType.APPLICATION_JSON)
	public PaymentDto updatePayment(PaymentDto payment) {
		return paymentService.update(payment);
	}

	@DELETE
	@Path("{id: \\d+}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void deletePayment(@PathParam("id") Long id) {
		paymentService.delete(id);
	}
	
	/*
	 * Initialize the domain model/ database ... on Start
	 */
	// @PostConstruct
	// private void intializeModel() {
	// Product product = new Product();
	// product.setName("Sled");
	// product.setDescription("Winter time fun");
	// product.setPrice(22.0F);
	//
	// productService.save(product);
	//
	// // Second product
	//
	// Product product2 = new Product();
	// product2.setName("Skates");
	// product2.setDescription("Winter time gliding");
	// product2.setPrice(44.0F);
	// product2.setStatus(ProductionStatus.PRODUCTION);
	//
	// product2 = productService.update(product2);
	//
	// }

}
