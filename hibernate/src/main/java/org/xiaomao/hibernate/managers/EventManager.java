package org.xiaomao.hibernate.managers;

import java.util.*;

import org.apache.poi.ss.formula.functions.Even;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		List events = session.createQuery(" from Event ").list();

		for (int i = 0; i < events.size(); i++) {
			Event theEvent = (Event) events.get(i);
			System.out.println("活动：" + theEvent.getTitle() + "，时间： " + theEvent.getDate());

			Set<Person> persons = theEvent.getParticipants();
			for (Person p : persons) {
				System.out.println(p.getFirstname() + p.getLastname());
			}
		}
	}

	@Test
	public void list2() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Map<String, Object>> result = session.createQuery(
				" select a.title as title, b.firstname as firstname, b.lastname as lastname FROM Event a join a.participants b ")
				.list();
		System.out.println(result.get(0).get("firstname"));
	}

	@Test
	public void addPersonToEvent() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Person person = new Person();
		person.setAge(1);
		person.setFirstname("f1");
		person.setLastname("l1");

		Set<Person> participants = new HashSet<Person>();
		participants.add(person);

		Event event = new Event();
		event.setDate(new Date());
		event.setTitle("title2");
		event.setParticipants(participants);
		event.setParticipants(participants);
		session.save(event);

		session.getTransaction().commit();
		session.close();
	}

}
