package org.xiaomao.java_study.design_pattern.singleton;

/**
 * 优点：简单，能保证单例
 * 缺点：即使单例没被用到，也会被实例化，占用资源
 */
public class EagerInitializedSingoleton {

	private static final EagerInitializedSingoleton instance = new EagerInitializedSingoleton();

	private EagerInitializedSingoleton() {
	}

	public static EagerInitializedSingoleton getInstance() {
		return instance;
	}
}
