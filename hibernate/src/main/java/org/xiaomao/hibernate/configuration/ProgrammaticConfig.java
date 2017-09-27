package org.xiaomao.hibernate.configuration;

import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.xiaomao.hibernate.entity.Event;

public class ProgrammaticConfig {

	@Test
	public void addByXML() {

		Configuration cfg = new Configuration().addResource("org/xiaomao/hibernate/entity/Event.hbm.xml");
		
	}

	@Test
	public void addByClass() {

		Configuration cfg = new Configuration().addClass(Event.class);

	}

}
