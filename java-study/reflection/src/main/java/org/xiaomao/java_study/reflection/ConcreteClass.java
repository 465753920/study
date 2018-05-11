package org.xiaomao.java_study.reflection;

public class ConcreteClass extends BaseClass implements BaseInterface {

	public int publicInt;
	protected boolean protectedBoolean;
	Object defaultObject;
	private String privateString = "private string";

	public ConcreteClass(int i) {
		this.publicInt = i;
	}

	@Override
	public void method1() {
		System.out.println("Method1 impl.");
	}

	@Override
	public int method2(String str) {
		System.out.println("Method2 impl.");
		return 0;
	}

	@Override
	public int method4() {
		System.out.println("Method4 overriden.");
		return 0;
	}

	public int method5(int i) {
		System.out.println("Method4 overriden.");
		return 0;
	}

	//member enum
	enum ConcreteClassDefaultEnum {
	}

	public enum ConcreteClassPublicEnum {}

	//member interface
	public interface ConcreteClassPublicInterface {
	}

	// inner classes
	public class ConcreteClassPublicClass {
	}

	private class ConcreteClassPrivateClass {
	}

	protected class ConcreteClassProtectedClass {
	}

	class ConcreteClassDefaultClass {
	}
}
