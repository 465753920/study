package org.xiaomao.hibernate.managers;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;
import org.xiaomao.hibernate.entity.Event;
import org.xiaomao.hibernate.entity.Person;
import org.xiaomao.hibernate.utils.HibernateUtil;

public class EventManager {

	@Test
	public void add() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Event theEvent = new Event();
		theEvent.setTitle("My Event");
		theEvent.setDate(new Date());
		session.save(theEvent);

		session.getTransaction().commit();
	}

	@Test
	public void list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List events = session.createQuery("from Event").list();
		session.getTransaction().commit();

		for (int i = 0; i < events.size(); i++) {
			Event theEvent = (Event) events.get(i);
			System.out.println("Event: " + theEvent.getTitle() + " Time: " + theEvent.getDate());
		}
	}

	@Test
	public void addPersonToEvent() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Event anEvent = new Event();
		anEvent.setDate(new Date());
		anEvent.setTitle("t1");

		Person aPerson = new Person();
		aPerson.setAge(5);
		aPerson.setFirstname("f1");
		aPerson.setLastname("l1");
		aPerson.getEvents().add(anEvent);

		session.save(aPerson);

		session.getTransaction().commit();
	}

}
