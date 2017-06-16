package org.xiaomao.study.quartz.example;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xiaomao.study.quartz.job.HelloJob;

public class SimpleExample {

	public void run() throws SchedulerException {
		Logger log = LoggerFactory.getLogger(SimpleExample.class);

		log.info("--------Initializing--------");
		// reference to a scheduler
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();
		log.info("--------Initializing Complete--------");

		// next round minute
		Date runTime = evenMinuteDate(new Date());

		log.info("--------Scheduling Job--------");
		// job detail
		JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();
		// trigger
		Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();
		// register job and trigger
		sched.scheduleJob(job, trigger);
		log.info(job.getKey() + " will run at: " + runTime);
		// start the scheduler
		sched.start();
		log.info("--------Scheduler Started--------");

		log.info("--------Wait 65 seconds...--------");
		try {
			Thread.sleep(65000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// shutdown the scheduler
		log.info("--------Shutting Down--------");
		sched.shutdown();
		log.info("--------Shutdown Complete--------");
	}

	public void run2() throws SchedulerException {
		Logger log = LoggerFactory.getLogger(SimpleExample.class);

		log.info("--------Initializing--------");
		// reference to a scheduler
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();
		log.info("--------Initializing Complete--------");

		// next round minute
		Date runTime = evenMinuteDate(new Date());
		log.info("--------Scheduling Job--------");
		// job detail
		JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();
		// trigger
		Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime)
				.withSchedule(simpleSchedule().withIntervalInMilliseconds(5000).withRepeatCount(10)).forJob(job)
				.build();
		sched.addJob(job, true, true);
		sched.scheduleJob(trigger);
		sched.start();
		log.info("--------Scheduler Started--------");
	}

	public static void main(String[] args) {

		SimpleExample example = new SimpleExample();
		try {
			example.run2();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}

	}

}
