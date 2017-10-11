package org.xiaomao.jpa.manager;

import org.junit.Before;
import org.junit.Test;
import org.xiaomao.jpa.entity.Employee;

public class ManagerTest {

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

}
