package org.xiaomao.study.quartz.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DumpJob2 implements Job {

	String jobSays;
	float floatNum;

	public DumpJob2() {

	}

	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		Logger log = LoggerFactory.getLogger(DumpJob2.class);
		
		JobKey key = context.getJobDetail().getKey();

		// Note the difference from the previous example
		JobDataMap dataMap = context.getMergedJobDataMap();

		log.info("Instance " + key + " of DumbJob says: " + jobSays + ", and val is: " + floatNum);
	}

	public void setJobSays(String jobSays) {
		this.jobSays = jobSays;
	}

	public void setFloatNum(float floatNum) {
		this.floatNum = floatNum;
	}

}
