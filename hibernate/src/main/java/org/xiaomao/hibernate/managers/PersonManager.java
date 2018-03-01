package org.xiaomao.hibernate.managers;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;
import org.xiaomao.hibernate.entity.Event;
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

		session.close();
	}

	@Test
	public void list() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();

		List<Person> persons = session.createQuery(" FROM Person ").list();

		for (Person p : persons) {
			System.out.println("名字：" + p.getFirstname() + p.getLastname() + "，年龄：" + p.getAge());

			Set<Event> events = p.getEvents();
			for (Event e : events) {
				System.out.println(e.getTitle());
			}
		}

		session.getTransaction().commit();
	}

	@Test
	public void list2() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Map<String, Object>> list = session.createQuery(
				" select new map(a.firstname as firstname, a.lastname as lastname, a.age as age, b.title as title) FROM Person a join a.events b ")
				.list();
		for (Map<String, Object> item : list) {
			System.out.println((String) item.get("firstname") + (String) item.get("lastname") + ", age "
					+ (Integer) item.get("age") + " ,title " + (String) item.get("title") + ".");
		}
	}

	@Test
	public void addEventToPerson() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Event anEvent = new Event();
		anEvent.setDate(new Date());
		anEvent.setTitle("title2");

		Set<Event> events = new HashSet<Event>();
		events.add(anEvent);

		Person aPerson = new Person();
		aPerson.setAge(2);
		aPerson.setFirstname("f2");
		aPerson.setLastname("l2");
		aPerson.setId(2L);
		aPerson.setEvents(events);

		session.save(aPerson);
		session.save(anEvent);

		session.getTransaction().commit();
	}

}
