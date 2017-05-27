package edu.mum.rest.service;

import edu.mum.domain.Payment;
import edu.mum.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.List;

@Component
@PropertySource("classpath:application.properties")
@Path("/reports")
public class ReportRestService {

	@Autowired
	private PaymentService paymentService;

	@Value("${output}")
	private String reportOutput;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<Payment> getProducts()
	{
		return paymentService.findAll();
	}

	@GET
    @Path("/{tripId:\\d+}/{date}")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
//	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductById(@PathParam("tripId") Long tripId, @PathParam("date") String date) {
		System.out.println("tripId"+ tripId);
		System.out.println("date"+ date);

		//2017-05-23
		//Payment_2017-05-23.txt
		String fileFolder = reportOutput + tripId+"/";
		String fileName = "Payment_"+date+".txt";
		String fileLocation = fileFolder + fileName;
		Response response = null;

		// Retrieve the file
		File file = new File(fileLocation);
		if (file.exists()) {
			Response.ResponseBuilder builder = Response.ok(file);
			builder.header("Content-Disposition", "attachment; filename=" + file.getName());
			response = builder.build();

			long file_size = file.length();
		} else {
			response = Response.status(404).
					entity("FILE NOT FOUND").
					type("text/plain").
					build();
		}

		return response;
 	}


}
