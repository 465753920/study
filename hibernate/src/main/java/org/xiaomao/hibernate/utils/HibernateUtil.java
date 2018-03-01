package org.xiaomao.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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

	public static List<Class<?>> getEntityClassesFromPackage(String packageName) throws ClassNotFoundException, IOException, URISyntaxException {
		List<String> classNames = getClassNamesFromPackage(packageName);
		List<Class<?>> classes = new ArrayList<>();
		for (String className : classNames) {
			Class<?> cls = Class.forName(packageName + "." + className);
			Annotation[] annotations = cls.getAnnotations();

			for (Annotation annotation : annotations) {
				System.out.println(cls.getCanonicalName() + ": " + annotation.toString());
				if (annotation instanceof javax.persistence.Entity) {
					classes.add(cls);
				}
			}
		}

		return classes;
	}

	public static ArrayList<String> getClassNamesFromPackage(String packageName) throws IOException, URISyntaxException, ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		ArrayList<String> names = new ArrayList<String>();

		packageName = packageName.replace(".", "/");
		URL packageURL = classLoader.getResource(packageName);

		URI uri = new URI(packageURL.toString());
		File folder = new File(uri.getPath());
		File[] files = folder.listFiles();
		for (File file : files) {
			String name = file.getName();
			name = name.substring(0, name.lastIndexOf('.'));  // remove ".class"
			names.add(name);
		}

		return names;
	}
}
