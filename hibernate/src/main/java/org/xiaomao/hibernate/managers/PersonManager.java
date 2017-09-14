package org.xiaomao.hibernate.managers;

import org.hibernate.Session;
import org.junit.Test;
import org.xiaomao.hibernate.entity.Person;
import org.xiaomao.hibernate.utils.HibernateUtil;

public class PersonManager {

	@Test
	public void add() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Person p = new Person();
		p.setAge(25);
		p.setFirstname("Shen");
		p.setLastname("QiuS");
		session.save(p);

		session.getTransaction().commit();
	}
	
}
