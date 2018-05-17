package org.xiaomao.java_study.design_pattern.factory;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ComputerFactoryTest {

	@Test
	public void getComputer() {
		ComputerFactory factory = ComputerFactory.getInstance();
		Computer pc = factory.getComputer(ComputerType.PC, "8G", "512G", "i5-4590");
		Computer server = factory.getComputer(ComputerType.SERVER, "64G", "2T", "Xeon-E5");
		System.out.println("PC: " + pc);
		System.out.println("Server: " + server);
	}

	@Test
	public void test() {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getCalendarType());
	}
}