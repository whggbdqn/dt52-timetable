package cn.bdqn.mapper;

import cn.bdqn.pojo.Classes;
import cn.bdqn.pojo.Schedule;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ScheduleMapper {
   
	List<Schedule> getallSchedule();
	
	Schedule getScheduleById(Integer pk);
	
	List<Schedule> getScheduleByClasses(Classes classes);
	
	List<Schedule> getScheduleBySchedule(Schedule schedule);
	
	 List<Schedule> getSchedules(Schedule schedule);
	
	int updateBySchedule(Schedule schedule);
	
	int deleteByScheduleId(Integer pk);

	int insertSchedule(Schedule schedule);
	
	List viewSchedule();
	
	int cleanSchedule();
	
	int addSchedule(Schedule[] schs);

	int addSch(List<Schedule> sch);
}