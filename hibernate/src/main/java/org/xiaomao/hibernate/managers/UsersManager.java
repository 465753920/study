package org.xiaomao.hibernate.managers;

import org.hibernate.Session;
import org.junit.Test;
import org.xiaomao.hibernate.entity.Group;
import org.xiaomao.hibernate.entity.User;
import org.xiaomao.hibernate.utils.HibernateUtil;

/**
 * A program that demonstrates using Hibernate framework to manage a
 * bidirectional many-to-many association in relational database.
 *
 * @author www.codejava.net
 */
public class UsersManager {

	@Test
	public void addGroupToUser() {
		Group group = new Group("g1");

		User user = new User("u1", "p1", "e1");
		user.setGroup(group);

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(user);

		session.getTransaction().commit();
		session.close();
	}

}