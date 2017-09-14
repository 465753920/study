package org.xiaomao.hibernate.managers;

import org.hibernate.Session;
import org.xiaomao.hibernate.entity.Group;
import org.xiaomao.hibernate.entity.User;
import org.xiaomao.hibernate.utils.HibernateUtil;

/**
 * A program that demonstrates using Hibernate framework to manage a
 * bidirectional many-to-many association in relational database.
 * 
 * @author www.codejava.net
 *
 */
public class UsersManager {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Group groupAdmin = new Group("Administrator Group");
		Group groupGuest = new Group("Guest Group");

		User user1 = new User("Tom", "tomcat", "tom@codejava.net");
		User user2 = new User("Mary", "mary", "mary@codejava.net");

		groupAdmin.addUser(user1);
		groupAdmin.addUser(user2);

		groupGuest.addUser(user1);

		user1.addGroup(groupAdmin);
		user2.addGroup(groupAdmin);
		user1.addGroup(groupGuest);

		session.save(groupAdmin);
		session.save(groupGuest);

		session.getTransaction().commit();
		session.close();
	}

}