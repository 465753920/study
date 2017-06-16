package org.xiaomao.study.quartz.example;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xiaomao.study.quartz.job.DumpJob;
import org.xiaomao.study.quartz.job.DumpJob2;

public class JobDataMapExample {

	public void run() throws SchedulerException {

		Logger log = LoggerFactory.getLogger(JobDataMapExample.class);

		log.info("--------Initializing--------");
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();
		log.info("--------Initialization Complete--------");

		log.info("--------Scheduling Job--------");
		Date runTime = evenMinuteDate(new Date());
		JobDetail job = newJob(DumpJob.class).withIdentity("job1", "group1").usingJobData("jobSays", "Hello World")
				.usingJobData("floatNum", 3.1415926F).build();
		Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();
		log.info("--------Job " + job + " will run at: " + runTime);
		sched.scheduleJob(job, trigger);
		sched.start();
		log.info("--------Scheduler Running--------");

		log.info("--------Wait for 65 seconds.--------");
		try {
			Thread.sleep(65000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("--------Scheduler Shutting Down--------");
		sched.shutdown();
		log.info("--------Scheduler Shutdown Complete--------");

	}

	public void run2() throws SchedulerException {

		Logger log = LoggerFactory.getLogger(JobDataMapExample.class);

		log.info("--------Initializing--------");
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();
		log.info("--------Initialization Complete--------");

		log.info("--------Scheduling Job--------");
		Date runTime = evenMinuteDate(new Date());
		JobDetail job = newJob(DumpJob2.class).withIdentity("job1", "group1").usingJobData("jobSays", "Hello World")
				.usingJobData("floatNum", 3.1415926F).build();
		Trigger trigger = newTrigger().withIdentity("trigger1", "group1").usingJobData("floatNum", 1.123456F)
				.startAt(runTime).build();
		log.info("--------Job " + job + " will run at: " + runTime);
		sched.scheduleJob(job, trigger);
		sched.start();
		log.info("--------Scheduler Running--------");

		log.info("--------Wait for 65 seconds.--------");
		try {
			Thread.sleep(65000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("--------Scheduler Shutting Down--------");
		sched.shutdown();
		log.info("--------Scheduler Shutdown Complete--------");

	}

	public static void main(String[] args) {

		JobDataMapExample example = new JobDataMapExample();
		try {
			example.run2();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}

	}

}
