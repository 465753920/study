package org.xiaomao.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		return new Configuration().configure().buildSessionFactory(new StandardServiceRegistryBuilder().build());
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}

}
