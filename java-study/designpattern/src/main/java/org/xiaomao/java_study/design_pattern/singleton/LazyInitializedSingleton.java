package org.xiaomao.java_study.design_pattern.singleton;

/**
 * 优点：单例未使用时不会占用资源
 * 缺点：并不是多线程安全，同时有多个线程在if判断里面时，会造成instance被覆盖
 */
public class LazyInitializedSingleton {

	private static LazyInitializedSingleton instance;

	private LazyInitializedSingleton() {
	}

	public static LazyInitializedSingleton getInstance() {
		if (instance == null) {
			instance = new LazyInitializedSingleton();
		}
		return instance;
	}
}
