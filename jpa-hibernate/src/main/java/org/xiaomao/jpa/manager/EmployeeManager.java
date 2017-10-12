package org.xiaomao.jpa.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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

	/**
	 * 验证UPPER()函数
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> upper() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Demo_1");

		EntityManager em = emfactory.createEntityManager();

		Query query = em.createQuery("Select UPPER(e.ename) from Employee e");
		List<String> names = query.getResultList();

		em.close();
		emfactory.close();

		return names;
	}

	/**
	 * 验证MAX()函数
	 * 
	 * @return
	 */
	public Double max() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Demo_1");

		EntityManager em = emfactory.createEntityManager();

		Query query = em.createQuery("Select MAX(e.salary) from Employee e");
		Double maxSalary = (double) query.getSingleResult();

		em.close();
		emfactory.close();

		return maxSalary;
	}

	/**
	 * 区间查询
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> between(Double min, Double max) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Demo_1");

		EntityManager em = emfactory.createEntityManager();

		Query query = em.createQuery("Select e from Employee e where e.salary Between " + min + " and " + max);
		List<Employee> result = query.getResultList();

		em.close();
		emfactory.close();

		return result;
	}

	/**
	 * 模糊查询
	 * 
	 * @param name
	 * @return
	 */
	public List<Employee> like(String name) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Demo_1");

		EntityManager em = emfactory.createEntityManager();

		Query query = em.createQuery("Select e from Employee e where e.ename like '" + name + "%'");
		List<Employee> result = query.getResultList();

		em.close();
		emfactory.close();

		return result;
	}

	/**
	 * 排序
	 * 
	 * @return
	 */
	public List<Employee> order() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Demo_1");

		EntityManager em = emfactory.createEntityManager();

		Query query = em.createQuery("Select e from Employee e order by e.eid desc");
		List<Employee> result = query.getResultList();

		em.close();
		emfactory.close();

		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> namedQueryById(Integer id) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Demo_1");

		EntityManager em = emfactory.createEntityManager();

		Query query = em.createNamedQuery("find employee by id");
		query.setParameter("id", id);
		return query.getResultList();
	}

}
