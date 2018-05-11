package org.xiaomao.java_study.design_pattern.singleton;

import org.junit.Test;

import java.io.*;

public class SerializedSingletonTest {

	@Test
	public void TestOne() {

		try {
			SerializedSingleton instanceOne = SerializedSingleton.getInstance();
			SerializedSingleton instanceTwo = null;
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream("serialization.txt"));
			out.writeObject(instanceOne);
			out.close();

			ObjectInput in = new ObjectInputStream(new FileInputStream("serialization.txt"));
			instanceTwo = (SerializedSingleton) in.readObject();
			in.close();

			System.out.println(instanceOne.hashCode());
			System.out.println(instanceTwo.hashCode());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}