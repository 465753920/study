package org.xiaomao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.xiaomao.hibernate.entity.OfficialDocumentUpgradePlan;
import org.xiaomao.hibernate.utils.HibernateUtil;
import org.xiaomao.hibernate.utils.IdGen;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		OfficialDocumentUpgradePlan plan = new OfficialDocumentUpgradePlan();
		plan.setId(IdGen.uuid());

		session.close();
		factory.close();
	}
}
