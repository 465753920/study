package org.xiaomao.hibernate.managers;

import org.hibernate.Session;
import org.junit.Test;
import org.xiaomao.hibernate.entity.Group;
import org.xiaomao.hibernate.entity.User;
import org.xiaomao.hibernate.utils.HibernateUtil;

import java.util.Set;

public class GroupManager {

	@Test
	public void addUserToGroup() {
		Group group = new Group("g3");

		User user = new User("u3", "p3", "e3");
		user.setGroup(group);

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(group);
		session.save(user);

		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void list() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Group group = (Group) session.get(Group.class, 3L);
		System.out.print(group.getName() + ": ");
		Set<User> users = group.getUsers();
		for (User user : users) {
			System.out.println(user.getUsername());
		}

		session.close();
	}
}
