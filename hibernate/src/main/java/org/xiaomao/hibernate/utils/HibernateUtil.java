package org.xiaomao.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties());
			return configuration.buildSessionFactory(builder.build());
		} catch (Throwable ex) {
			System.err.println("创建SessionFactory失败。" + ex);
			throw new ExceptionInInitializerError(ex);
		}

		// return new Configuration().configure().buildSessionFactory(new
		// StandardServiceRegistryBuilder().build());
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
