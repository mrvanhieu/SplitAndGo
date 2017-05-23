package edu.mum.batch;

import java.time.LocalDate;
import java.util.Map;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class BatchScheduler extends QuartzJobBean {

	private JobLauncher jobLauncher;

	private JobLocator jobLocator;

	private String jobName;

	public JobLauncher getJobLauncher() {
		return jobLauncher;
	}

	public void setJobLauncher(JobLauncher jobLauncher) {
		this.jobLauncher = jobLauncher;
	}

	public JobLocator getJobLocator() {
		return jobLocator;
	}

	public void setJobLocator(JobLocator jobLocator) {
		this.jobLocator = jobLocator;
	}



	@Override
	protected void executeInternal(JobExecutionContext context)

			throws JobExecutionException {

		Map mapData = context.getMergedJobDataMap();

		jobName = (String) mapData.get("jobName");

		try {

			JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
			LocalDate date1 = LocalDate.now();
			System.out.println("Current date: " + date1);
			jobParametersBuilder.addString("date", date1.toString());
			jobParametersBuilder.addLong("time", System.currentTimeMillis());
			JobParameters jobParameters = jobParametersBuilder.toJobParameters();

			JobExecution execution = jobLauncher.run(jobLocator.getJob(jobName), jobParameters);

			System.out.println("Execution Status: " + execution.getStatus());

		} catch (Exception e) {

			System.out.println("Encountered job execution exception! ");

			e.printStackTrace();

		}

	}

}
