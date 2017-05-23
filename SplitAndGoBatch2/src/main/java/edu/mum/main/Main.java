package edu.mum.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		Main obj = new Main();
		obj.run();

	}

	private void run() {

		String[] springConfig = { "context/application-context.xml", "context/daily-job.xml" };

		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);

//		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
//		Job job = (Job) context.getBean("dailyJob");
//
//		try {
//
//			
//			JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
//			
//			LocalDate date1 = LocalDate.now();
//			System.out.println("Current date: " + date1);
//			
//		  // jobParametersBuilder.addDate("date",dateFormat.format(date));
//		    jobParametersBuilder.addString("date",date1.toString());
//		    JobParameters jobParameters = jobParametersBuilder.toJobParameters();
//			JobExecution execution = jobLauncher.run(job, jobParameters);
//			System.out.println("Exit Status : " + execution.getStatus());
//			System.out.println("Exit Status : " + execution.getAllFailureExceptions());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}

		System.out.println("Done");

	}

}
