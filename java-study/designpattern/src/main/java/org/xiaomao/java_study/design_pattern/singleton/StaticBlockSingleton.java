package org.xiaomao.java_study.design_pattern.singleton;

/**
 * 优点：跟EagerInitialize对比，可能在实例新建时进行报错操作
 * 缺点：即使单例没被用到，也会被实例化，占用资源
 */
public class StaticBlockSingleton {

	static{
		try {
			instance = new StaticBlockSingleton();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static StaticBlockSingleton instance=null;

	private StaticBlockSingleton(){};

	public static StaticBlockSingleton getInstance(){
		return instance;
	}
}
