package org.xiaomao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

public class TestClass {

	private SessionFactory factory;

	@Before
	public void before() {
		try {
			Configuration configuration = new Configuration().configure().addAnnotatedClass(A.class)
					.addAnnotatedClass(B.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties());
			factory = configuration.buildSessionFactory(builder.build());
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	@Test
	public void test1() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery(" FROM Example ");
			query.setFirstResult(0);
			query.setMaxResults(100);
			List<Example> examples = query.list();
			System.out.println(examples.size());
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Test
	public void test2() {
		 Session session = factory.openSession();
		 Transaction tx = session.beginTransaction();
		 A a = new A();
		 a.setId("002");
		 a.setFkBId("101");
		 a.setName("a2");
		 session.save(a);
		// session.persist(a);
		 session.flush();
		 tx.commit();
		 session.close();

//		Session session = factory.openSession();
//		Transaction tx = session.beginTransaction();
//		B b = new B();
//		b.setId("101");
//		b.setName("b1");
//		session.save(b);
//		// session.persist(b);
//		session.flush();
//		tx.commit();
//		session.close();
	}

	@Test
	public void test3() {
		Session session = factory.openSession();
		String hql = " from A a join a.b b where 1=1 ";
		Query query = session.createQuery(hql);
		List list = query.list();
		System.out.println(query.list().get(0).toString());
		session.close();
	}

}
