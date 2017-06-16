package org.xiaomao.study.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloJob implements Job {

	public HelloJob() {
	}

	public void execute(JobExecutionContext context) throws JobExecutionException {

		Logger log = LoggerFactory.getLogger(HelloJob.class);

		log.info("Hello!  HelloJob is executing.");

	}

}
