package org.xiaomao.java_study.mybatis_test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.xiaomao.java_study.mybatis_test.entity.Student;

import java.io.IOException;
import java.io.Reader;

public class MainClass {

	public static void main(String args[]) throws IOException {

		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlSessionFactory.openSession();

		//Create a new student object
		Student student = new Student("Mohammad", "It", 80, 984803322, "Mohammad@gmail.com");

		//Insert student data
		session.insert("Student.insert", student);
		System.out.println("record inserted successfully");
		session.commit(); 
		session.close();
	}
}
