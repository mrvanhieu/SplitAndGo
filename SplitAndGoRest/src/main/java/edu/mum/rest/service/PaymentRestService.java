package edu.mum.rest.service;

import edu.mum.domain.Payment;
import edu.mum.domain.Trip;
import edu.mum.service.PaymentService;
import edu.mum.service.TripService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

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
	public Payment getProductById(@PathParam("id") Long id) {
		return paymentService.findOne(id);
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(MediaType.APPLICATION_JSON)
	public void savePayment(Payment payment) {
		Trip trip = tripService.findOne(payment.getTrip().getId());
		payment.setTrip(trip);
		paymentService.update(payment);
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(MediaType.APPLICATION_JSON)
	public Payment updateProduct(Payment product) {
		return paymentService.update(product);
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
