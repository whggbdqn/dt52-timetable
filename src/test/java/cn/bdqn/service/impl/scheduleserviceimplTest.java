package cn.bdqn.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.bdqn.BaseTest;
import cn.bdqn.pojo.Schedule;
import cn.bdqn.service.scheduleservice;

public class scheduleserviceimplTest extends BaseTest{


	@Autowired
	private scheduleservice scheduleserviceimpl;
	@Test
	public void testInsertSchedule() {
		Schedule schedule = new Schedule();
		schedule.setClassesId(5);
		int num = scheduleserviceimpl.insertSchedule(schedule);
		assertEquals(1, num);
	}

}
