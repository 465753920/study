package org.xiaomao.jpa.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.xiaomao.jpa.entity.Employee;

public class EmployeeManager {

	public void createEmployee() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Demo_1");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Employee employee = new Employee();
		employee.setEname("ShenQiuS");
		employee.setSalary(60000.0);
		employee.setDeg("Software Engineer");

		entitymanager.persist(employee);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}

	public Employee findEmployee(Integer id) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Demo_1");

		EntityManager em = emfactory.createEntityManager();

		Employee employee = em.find(Employee.class, id);

		em.close();
		emfactory.close();
		
		return employee;
	}

	public void deleteEmploy(Integer id) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Demo_1");

		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		
		Employee employee = em.find(Employee.class, id);
		em.remove(employee);
		
		em.getTransaction().commit();
		
		em.close();
		emfactory.close();
	}

}
