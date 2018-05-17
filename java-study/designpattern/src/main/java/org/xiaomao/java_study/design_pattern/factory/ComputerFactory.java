package org.xiaomao.java_study.design_pattern.factory;

/**
 * ComputerFactory用于创建Computer，ComputerFactory是单例
 */
public class ComputerFactory {

	private ComputerFactory() {}

	public static ComputerFactory getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public Computer getComputer(ComputerType type, String ram, String hdd, String cpu) {
		if (type == null)
			return null;
		switch (type) {
			case PC:
				return new PC(ram, hdd, cpu);
			case SERVER:
				return new Server(ram, hdd, cpu);
			default:
				return null;
		}
	}

	private static class SingletonHelper {
		private static final ComputerFactory INSTANCE = new ComputerFactory();
	}
}
