package org.xiaomao.jpa.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.xiaomao.jpa.entity.singleTableStrategy.Staff;

public class StaffManager {

	public void createStaff(Staff s) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Demo_1");

		EntityManager em = emfactory.createEntityManager();

		em.getTransaction().begin();

		em.persist(s);

		em.getTransaction().commit();

		em.close();
		emfactory.close();
	}

}
