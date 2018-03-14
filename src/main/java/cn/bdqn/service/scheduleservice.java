package cn.bdqn.service;

import java.util.List;

import cn.bdqn.pojo.Classes;
import cn.bdqn.pojo.Schedule;

public interface scheduleservice {

	List<Schedule> getallSchedule();
	
	Schedule getScheduleById(Integer pk);
	
	List<Schedule> getScheduleByClasses(Classes classes);
	
	List<Schedule> getScheduleBySchedule(Schedule schedule);
	
	int updateBySchedule(Schedule schedule);
	
	int deleteByScheduleId(Integer pk);

	int insertSchedule(Schedule schedule);

	List<Schedule> getSchedules(Schedule schedule);
	
	int cleanSchedule();
	
	int addSchedule(Schedule[] schs);

	int addSch(List<Schedule> sch);
}
