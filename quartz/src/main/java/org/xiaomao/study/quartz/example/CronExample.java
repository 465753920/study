package org.xiaomao.study.quartz.example;

import static org.quartz.CronScheduleBuilder.cronSchedule;
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
import org.xiaomao.study.quartz.job.HelloJob;

public class CronExample {

	public void run() throws SchedulerException {

		Logger log = LoggerFactory.getLogger(CronExample.class);

		log.info("--------Initializing--------");

		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();
		
		Date runTime = evenMinuteDate(new Date());
		JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();
		Trigger trigger = newTrigger().withIdentity("trigger1", "group1").withSchedule(cronSchedule("0/5 * * * * ?"))
				.startAt(runTime).build();
		sched.scheduleJob(job, trigger);

		log.info("--------Start--------");
		sched.start();
		log.info("--------Running--------");

	}

	public static void main(String[] args) {

		CronExample example = new CronExample();
		try {
			example.run();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}

	}

}
