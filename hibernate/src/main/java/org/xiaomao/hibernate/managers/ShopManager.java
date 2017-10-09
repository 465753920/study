package org.xiaomao.hibernate.managers;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;
import org.xiaomao.hibernate.entity.Shop;
import org.xiaomao.hibernate.utils.HibernateUtil;

public class ShopManager {

	@Test
	public void add() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Shop shop = new Shop();
		shop.setName("全家");
		shop.setAddress("黄浦区大沙地");
		session.save(shop);

		session.getTransaction().commit();
	}

	@Test
	public void list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		List<Shop> list = session.createQuery(" FROM Shop ").list();

		for (Shop s : list) {
			System.out.println("名称：" + s.getName() + "，地址：" + s.getAddress());
		}

		session.getTransaction().commit();
	}

}
