package org.xiaomao.jpa.manager;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.xiaomao.jpa.entity.Employee;

public class EmployeeManagerTest {

	private EmployeeManager em;

	@Before
	public void before() {
		em = new EmployeeManager();
	}

	@Test
	public void createEmployee() {
		em.createEmployee();
	}

	@Test
	public void findEmployee() {
		Employee employee = em.findEmployee(1205);
		System.out.println(employee);
	}

	@Test
	public void deleteEmployee() {
		em.deleteEmploy(1201);
		Employee employee = em.findEmployee(1201);
		System.out.println(employee);
	}

	@Test
	public void upperNames() {
		List<String> names = em.upper();

		for (String name : names) {
			System.out.println(name);
		}
	}

	@Test
	public void maxSalary() {
		Double maxSalary = em.max();

		System.out.println(maxSalary);
	}

	@Test
	public void betweenSalary() {
		List<Employee> employees = em.between(30000.0, 50000.0);

		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

	@Test
	public void likeName() {
		List<Employee> employees = em.like("S");

		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

	@Test
	public void orderById() {
		List<Employee> employees = em.order();

		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

}
