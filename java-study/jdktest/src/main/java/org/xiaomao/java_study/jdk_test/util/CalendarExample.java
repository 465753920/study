package org.xiaomao.java_study.jdk_test.util;

import java.util.Calendar;
import java.util.TimeZone;

public class CalendarExample {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getCalendarType());
		System.out.println("Hour at " + calendar.getTimeZone().getID() + ": " + calendar.get(Calendar.HOUR_OF_DAY));
		calendar.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
		System.out.println("Hour at " + calendar.getTimeZone().getID() + ": " + calendar.get(Calendar.HOUR_OF_DAY));
	}
}
