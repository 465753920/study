package org.xiaomao.hibernate.managers;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;
import org.xiaomao.hibernate.entity.Event;
import org.xiaomao.hibernate.utils.HibernateUtil;

public class EventManager {

	@Test
	public void test1() {
		createAndStoreEvent("My Event", new Date());
	}

	@Test
	public void test2() {
		List events = listEvents();
		for (int i = 0; i < events.size(); i++) {
			Event theEvent = (Event) events.get(i);
			System.out.println("Event: " + theEvent.getTitle() + " Time: " + theEvent.getDate());
		}
	}

	private void createAndStoreEvent(String title, Date theDate) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Event theEvent = new Event();
		theEvent.setTitle(title);
		theEvent.setDate(theDate);
		session.save(theEvent);

		session.getTransaction().commit();
	}

	private List listEvents() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List result = session.createQuery("from Event").list();
		session.getTransaction().commit();
		return result;
	}

}
