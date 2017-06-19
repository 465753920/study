package org.xiaomao.study.quartz.example;

import java.util.Date;

import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerMetaData;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xiaomao.study.quartz.job.StatefulDumbJob;

public class MisfireExample {

	public void run() throws SchedulerException {

		Logger log = LoggerFactory.getLogger(MisfireExample.class);

		log.info("-------- Initializing --------");

		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();

		log.info("-------- Initialization Complete --------");

		log.info("-------- Scheduling Jobs --------");

		Date startTime = DateBuilder.nextGivenSecondDate(null, 15);

		JobDetail job = JobBuilder.newJob(StatefulDumbJob.class).withIdentity("job1", "group1")
				.usingJobData(StatefulDumbJob.EXECUTION_DELAY, 10000L).build();

		SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startAt(startTime)
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever()).build();

		Date ft = sched.scheduleJob(job, trigger);
		log.info(
				job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() + " times, every "
						+ trigger.getRepeatInterval() / 1000 + " seconds."
		);

		job = JobBuilder.newJob(StatefulDumbJob.class).withIdentity("job2", "group1")
				.usingJobData(StatefulDumbJob.EXECUTION_DELAY, 10000L).build();

		trigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group1").startAt(startTime)
				.withSchedule(
						SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever()
								.withMisfireHandlingInstructionNowWithExistingCount()
				).build();

		// ft = sched.scheduleJob(job, trigger);
		log.info(
				job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() + " times, every "
						+ trigger.getRepeatInterval() / 1000 + " seconds."
		);

		log.info("-------- Starting Scheduler --------");

		sched.start();

		log.info("-------- Started --------");

		log.info("-------- Main Thread Sleep 10 Minutes --------");

		try {
			Thread.sleep(6L * 60L * 1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.info("-------- Shutting Down Scheduler --------");

		sched.shutdown(true);

		log.info("-------- Shutdown Complete --------");

		SchedulerMetaData metaData = sched.getMetaData();
		log.info("Executed " + metaData.getNumberOfJobsExecuted() + " jobs.");

	}

	public static void main(String[] args) {

		MisfireExample example = new MisfireExample();

		try {
			example.run();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}

	}

}
