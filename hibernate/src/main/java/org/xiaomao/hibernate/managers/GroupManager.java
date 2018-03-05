package org.xiaomao.hibernate.managers;

import org.hibernate.HibernateException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;
import org.xiaomao.hibernate.entity.Group;
import org.xiaomao.hibernate.entity.User;
import org.xiaomao.hibernate.utils.HibernateUtil;

import java.util.Set;

public class GroupManager {

	@Test
	public void addUserToGroup() {
		Group group = new Group("g4");

		User user = new User("u4", "p4", "e4");
		user.setGroup(group);

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(group);
		session.save(user);

		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void addUserToGroup2() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			String groupName = "g4";

			Query query = session.createQuery(" from Group where name = :name ");
			query.setParameter("name", groupName);
			Group group = (Group) query.uniqueResult();

			if (group != null) {
				User user1 = new User();
				user1.setGroup(group);
				user1.setEmail("email");
				user1.setUsername("username");
				user1.setPassword("password");
				User user2 = new User();
				user2.setGroup(group);
				user2.setEmail("email");
				user2.setUsername("username");
				user2.setPassword("password");

				session.save(group);
				session.save(user1);
				session.save(user2);
			} else {
				System.out.println("找不到组-" + groupName);
			}

			session.getTransaction().commit();
			session.close();
		} catch (NonUniqueResultException e) {
			System.out.println("组名重复");
			e.printStackTrace();
		}
	}

	@Test
	public void list() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Group group = (Group) session.get(Group.class, 4L);
		System.out.println("组名：" + group.getName());
		Set<User> users = group.getUsers();
		for (User user : users) {
			System.out.println("人名：" + user.getUsername());
		}

		session.close();
	}

	@Test
	public void findGroupByName() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		String groupName = "g4";

		Query query = session.createQuery(" from Group where name = :name ");
		query.setParameter("name", groupName);
		Group group = (Group) query.uniqueResult();

		if (group != null) {
			System.out.println("组-" + group.getName());
			for (User user : group.getUsers()) {
				System.out.println(user.getUsername());
			}
		} else {
			System.out.println("未找到组-" + groupName);
		}

		session.close();
	}
}
