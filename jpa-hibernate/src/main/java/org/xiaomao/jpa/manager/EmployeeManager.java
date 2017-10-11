package org.xiaomao.jpa.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.xiaomao.jpa.entity.Employee;

public class EmployeeManager {

	public static void main(String[] args) {

		EmployeeManager em = new EmployeeManager();

		em.createEmployee();

	}

	public void createEmployee() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Demo_1");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Employee employee = new Employee();
		employee.setEname("ShenQiuS");
		employee.setSalary(60000);
		employee.setDeg("Software Engineer");

		entitymanager.persist(employee);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}

}
