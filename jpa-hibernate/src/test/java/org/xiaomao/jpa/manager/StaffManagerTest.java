package org.xiaomao.jpa.manager;

import org.junit.Before;
import org.junit.Test;
import org.xiaomao.jpa.entity.singleTableStrategy.NonTeachingStaff;
import org.xiaomao.jpa.entity.singleTableStrategy.Staff;
import org.xiaomao.jpa.entity.singleTableStrategy.TeachingStaff;

public class StaffManagerTest {

	private StaffManager sm;

	@Before
	public void before() {
		sm = new StaffManager();
	}

	@Test
	public void createStaff() {
		TeachingStaff ts = new TeachingStaff("小李", "本科", "数学");
		sm.createStaff(ts);

		NonTeachingStaff ns = new NonTeachingStaff("小红", "经理");
		sm.createStaff(ns);

		Staff s = new Staff("沈秋盛");
		sm.createStaff(s);
	}

}
