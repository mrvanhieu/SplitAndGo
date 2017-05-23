package edu.mum.rest.service;

import edu.mum.domain.Payment;
import edu.mum.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/reports")
public class ReportRestService {

	@Autowired
	private PaymentService paymentService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<Payment> getProducts()
	{	 
		return paymentService.findAll();
	}

	@GET
    @Path("/{tripId}/{date}")
    @Produces(MediaType.APPLICATION_JSON)
	public Payment getProductById(@PathParam("tripId") Long tripId, String date) {
		System.out.println("tripId"+ tripId);
		System.out.println("date"+ date);
		return null;
 	}
	
    @POST
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces(MediaType.APPLICATION_JSON)
	public Payment saveProduct(Payment product)
	{
		paymentService.save(product);
		return null;
	}
 

	/*
	 * Initialize the domain model/ database ...
	 * on Start
	 */
//	@PostConstruct
//	private void intializeModel() {
//	    Product product = new Product();
//	    product.setName("Sled");
//	    product.setDescription("Winter time fun");
//	    product.setPrice(22.0F);
//
//		productService.save(product);
//
//	 // Second product
//
//	    Product product2 = new Product();
//	    product2.setName("Skates");
//	    product2.setDescription("Winter time gliding");
//	    product2.setPrice(44.0F);
//	    product2.setStatus(ProductionStatus.PRODUCTION);
//
//    	product2 = productService.update(product2);
//
//	}

 
}
