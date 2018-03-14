import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysql.fabric.xmlrpc.base.Array;

import cn.bdqn.mapper.ScheduleMapper;
import cn.bdqn.pojo.Schedule;


public class ScheduleTest {

	private ScheduleMapper bean;

	@Before
	public void setUp() throws Exception {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext-mybatis.xml","applicationContext-service.xml");
		bean = context.getBean(ScheduleMapper.class);
	}

	@Test
	public void test() {
		List list = bean.viewSchedule();
		for (Object object : list) {
			System.out.println(object);
		}
	}
	@Test
	public void testaddsch() {
		Schedule schedule = new Schedule();
		schedule.setClassesId(9);
		schedule.setCourseId(9);
		schedule.setRoomId(7);
		schedule.setTeacherId(9);
		schedule.setSchTime("全天");
		schedule.setSchDate(new Date());
		schedule.setWeek("周1");
		Schedule[] schs = new Schedule[3];
		for(int i=0;i<3;i++){
			schs[i]=schedule;
			System.out.println(schs[i]);
		}
		bean.addSchedule(schs);
	}
	
	@Test
	public void testaddsch2() {
		Schedule schedule = new Schedule();
		List<Schedule> schs = new ArrayList<Schedule>();
		schedule.setClassesId(9);
		schedule.setCourseId(9);
		schedule.setRoomId(7);
		schedule.setTeacherId(9);
		schedule.setSchTime("全天");
		schedule.setSchDate(new Date());
		schedule.setWeek("周1");
			
		for(int i=0;i<3;i++){
		schs.add(schedule);
//			System.out.println(schedule);
		}
		int addSch = bean.addSch(schs);
		System.out.println(addSch);
	}
	
}
