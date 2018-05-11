package org.xiaomao.java_study.design_pattern.singleton;

import java.lang.reflect.Constructor;

public class DestorySingletonTest {

	public static void main(String[] args) {
		EagerInitializedSingoleton instanceOne = EagerInitializedSingoleton.getInstance();
		EagerInitializedSingoleton instanceTwo = null;
		Constructor[] constructors = EagerInitializedSingoleton.class.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
			constructor.setAccessible(true);
			try {
				instanceTwo = (EagerInitializedSingoleton) constructor.newInstance();
				System.out.println(instanceOne.hashCode());
				System.out.println(instanceTwo.hashCode());
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
