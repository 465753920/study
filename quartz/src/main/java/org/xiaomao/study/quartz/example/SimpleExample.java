package org.xiaomao.study.quartz.example;

import static org.quartz.JobBuilder.newJob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xiaomao.study.quartz.job.HelloJob;

public class SimpleExample {

	public void run() {
		newJob(HelloJob.class);
	}

	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(SimpleExample.class);
		log.info("hello world");
		log.info("hello world");
	}

}
