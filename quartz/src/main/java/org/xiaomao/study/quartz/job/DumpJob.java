package org.xiaomao.study.quartz.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DumpJob implements Job {

	public DumpJob() {

	}

	public void execute(JobExecutionContext context) throws JobExecutionException {

		Logger log = LoggerFactory.getLogger(DumpJob.class);

		JobKey key = context.getJobDetail().getKey();

		JobDataMap dataMap = context.getJobDetail().getJobDataMap();

		String jobSays = dataMap.getString("jobSays");
		float floatNum = dataMap.getFloat("floatNum");

		log.info("Instance " + key + " of DumbJob says: " + jobSays + ", and val is: " + floatNum);

	}

}
