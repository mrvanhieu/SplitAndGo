package edu.mum.batch.controller;

import java.time.LocalDate;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchJobController {
	
	@Autowired
    JobLauncher jobLauncher;
  
    @Autowired
    Job dailyJob;
     
    @RequestMapping("/launchjob")
    public String handle() throws Exception {
  
//        Logger logger = LoggerFactory.getLogger(this.getClass());
        try {
        	JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
			
			LocalDate date1 = LocalDate.now();
			System.out.println("Current date: " + date1);
			
		  // jobParametersBuilder.addDate("date",dateFormat.format(date));
		    jobParametersBuilder.addString("date",date1.toString());
		    jobParametersBuilder.addLong("time", System.currentTimeMillis());
		    
		    JobParameters jobParameters = jobParametersBuilder.toJobParameters();
		    
			JobExecution execution = jobLauncher.run(dailyJob, jobParameters);
			
			System.out.println("Exit Status : " + execution.getStatus());
			System.out.println("Exit Status : " + execution.getAllFailureExceptions());
        } catch (Exception e) {
           // logger.info(e.getMessage());
        }
  
        return "Done";
    }

}
