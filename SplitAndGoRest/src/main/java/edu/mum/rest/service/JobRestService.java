package edu.mum.rest.service;

import edu.mum.domain.Payment;
import edu.mum.service.PaymentService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.List;

@Component
@Path("/launchjob")
public class JobRestService {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job dailyJob;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public String handle() throws Exception {

    	try {
			JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();

			LocalDate date1 = LocalDate.now();
			System.out.println("Current date: " + date1);

			jobParametersBuilder.addString("date",date1.toString());
			jobParametersBuilder.addLong("time", System.currentTimeMillis());

			JobParameters jobParameters = jobParametersBuilder.toJobParameters();

			JobExecution execution = jobLauncher.run(dailyJob, jobParameters);

			System.out.println("Exit Status : " + execution.getStatus());
			System.out.println("Exit Status : " + execution.getAllFailureExceptions());
		} catch (Exception e) {

		}

		return "Done";
	}
}
