package edu.mum.integration;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

@MessageEndpoint
public class JobExecutionsRouter {
	
	@Router(inputChannel="jobExecutions")
	public String routeJobExecution(JobExecution jobExecution) {

		String routeToChannel = "mailChannel";

		if (jobExecution.getStatus().equals(BatchStatus.FAILED)) {
			routeToChannel = "jobRestarts";
		}
		
		return routeToChannel;
	}

}
