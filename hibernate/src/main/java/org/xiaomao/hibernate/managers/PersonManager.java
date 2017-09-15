package org.xiaomao.hibernate.managers;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
	}

	@Test
	public void list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Person> persons = session.createQuery(" FROM Person ").list();

		for (Person p : persons) {
			System.out.println("Ãû×Ö£º" + p.getFirstname() + p.getLastname() + "£¬ÄêÁä£º" + p.getAge());

			Set<Event> events = p.getEvents();
			for (Event e : events) {
				System.out.println(e.getTitle());
			}
		}
	}
	
	@Test
	public void list2() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.createQuery(" FROM Person a join a.events ").list();
	}

	@Test
	public void addEventToPerson() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Event anEvent = new Event();
		anEvent.setDate(new Date());
		anEvent.setTitle("t2");

		Set<Event> events = new HashSet<Event>();
		events.add(anEvent);

		Person aPerson = new Person();
		aPerson.setAge(5);
		aPerson.setFirstname("f2");
		aPerson.setLastname("l2");
		aPerson.setEvents(events);

		session.save(aPerson);
		session.save(anEvent);

		session.getTransaction().commit();
	}

}
