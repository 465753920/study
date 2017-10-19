package org.xiaomao.jpa.manager;

import org.junit.Before;
import org.junit.Test;
import org.xiaomao.jpa.entity.joinedTableStrategy.NonTeachingStaff;
import org.xiaomao.jpa.entity.joinedTableStrategy.Staff;
import org.xiaomao.jpa.entity.joinedTableStrategy.TeachingStaff;

public class StaffManagerJoinedTest {

	private StaffManagerJoined sm;

	@Before
	public void before() {
		sm = new StaffManagerJoined();
	}

	@Test
	public void createStaff() {
		TeachingStaff ts = new TeachingStaff("小李", "本科", "数学");
		sm.createStaff(ts);

		NonTeachingStaff ns = new NonTeachingStaff("小黄", "经理");
		sm.createStaff(ns);

		Staff s = new Staff("沈秋盛");
		sm.createStaff(s);
	}

}
