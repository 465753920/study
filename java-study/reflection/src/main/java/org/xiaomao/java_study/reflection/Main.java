package org.xiaomao.java_study.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		//四种获取Class的方法
		System.out.println("--------获取Class--------");
		Class<?> concreteClass = ConcreteClass.class;
		System.out.println(concreteClass.getCanonicalName());
		concreteClass = new ConcreteClass(5).getClass();
		System.out.println(concreteClass.getCanonicalName());
		try {
			concreteClass = Class.forName("org.xiaomao.java_study.reflection.ConcreteClass");
			System.out.println(concreteClass.getCanonicalName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Class<?> cDouble = Double.TYPE;
		System.out.println(cDouble.getCanonicalName());

		//get super class
		System.out.println("--------get super class--------");
		System.out.println(concreteClass.getSuperclass()); // prints "class com.journaldev.reflection.BaseClass"
		System.out.println(Object.class.getSuperclass()); // prints "null"
		System.out.println(String[][].class.getSuperclass());// prints "class java.lang.Object"

		//get public member classes
		Class<?>[] classes = concreteClass.getClasses();
		System.out.println("--------get public member classes--------");
		System.out.println(Arrays.toString(classes));

		//get declared classes
		System.out.println("--------get declared classes--------");
		System.out.println(Arrays.toString(concreteClass.getDeclaredClasses()));

		//get declaring classes
		Class<?> innerClass = ConcreteClass.ConcreteClassDefaultClass.class;
		System.out.println("--------get declaring class--------");
		System.out.println(innerClass.getDeclaringClass());

		//get package
		System.out.println("--------get package--------");
		System.out.println(concreteClass.getPackage().getName());

		//get class modifiers
		System.out.println("--------get class modifiers--------");
		System.out.println(Modifier.toString(concreteClass.getModifiers()));

		//get type parameters
		System.out.println("--------get type parameter--------");
		TypeVariable<?>[] typeParameters = HashMap.class.getTypeParameters();
		for (TypeVariable<?> typeParameter : typeParameters)
			System.out.print(typeParameter.getName() + ", ");
		System.out.println();

		//get implemented interfaces
		System.out.println("--------get implemented interfaces--------");
		System.out.println(Arrays.toString(HashMap.class.getGenericInterfaces()));
		System.out.println(Arrays.toString(HashMap.class.getInterfaces()));

		//get methods
		Method[] publicMethods = concreteClass.getMethods();
		System.out.println("--------get methods--------");
		System.out.println("Public Methods: " + Arrays.toString(publicMethods));

		//get all public constructors
		Constructor<?>[] publicConstructors = concreteClass.getConstructors();
		System.out.println("--------get constructors--------");
		System.out.println("Public Constructors: " + Arrays.toString(publicConstructors));
		System.out.println("Declared Constructors: " + Arrays.toString(concreteClass.getDeclaredConstructors()));
		System.out.println("Enclosing Constructor: " + concreteClass.getEnclosingConstructor());

		//get fields
		Field[] publicFields = concreteClass.getFields();
		System.out.println("--------get fields--------");
		System.out.println("Public Fields: " + Arrays.toString(publicFields));

		//get annotations
		Annotation[] annotations = concreteClass.getAnnotations();
		System.out.println("--------get annotations--------");
		System.out.println("Annotations: " + Arrays.toString(annotations));

		//get public fields
		try {
			Field field = ConcreteClass.class.getField("interfaceInt");
			System.out.println("--------get public field--------");
			Class<?> clazz = field.getDeclaringClass();
			Class<?> fieldClass = field.getType();
			System.out.println(clazz.getCanonicalName() + " declaring " + fieldClass.getCanonicalName() + " " + field.getName());
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}

		//change field value
		try {
			System.out.println("--------change field value--------");
			System.out.println("--------get/set public value--------");
			ConcreteClass item = new ConcreteClass(5);
			Field publicField = item.getClass().getField("publicInt");
			System.out.println("Original value: " + publicField.get(item));
			publicField.setInt(item, 8);
			System.out.println("Changed value: " + publicField.get(item));

			System.out.println("--------get/set private value--------");
			Field privateField = item.getClass().getDeclaredField("privateString");
			privateField.setAccessible(true);
			System.out.println("Original value: " + privateField.get(item));
			privateField.set(item, "abc");
			System.out.println("Changed value: " + privateField.get(item));
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		//get public constructors and instantiate object
		try {
			System.out.println("--------get public constructors--------");
			Constructor<?> constructor = Class.forName("org.xiaomao.java_study.reflection.ConcreteClass").getConstructor(int.class);
			System.out.println(constructor.getName() + " parameterTypes: " + Arrays.toString(constructor.getParameterTypes()));

			System.out.println("--------instantiation--------");
			ConcreteClass myObj = (ConcreteClass) constructor.newInstance(10);
			Method myObjMethod = myObj.getClass().getMethod("method1", null);
			myObjMethod.invoke(myObj, null);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
