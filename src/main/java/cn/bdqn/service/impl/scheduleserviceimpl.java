package cn.bdqn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.mapper.ScheduleMapper;
import cn.bdqn.pojo.Classes;
import cn.bdqn.pojo.Schedule;
import cn.bdqn.service.scheduleservice;

@Service
public class scheduleserviceimpl implements scheduleservice {

	@Autowired
	private ScheduleMapper schedulemapper;
	
	@Override
	public List<Schedule> getallSchedule() {
		return schedulemapper.getallSchedule();
	}

	@Override
	public Schedule getScheduleById(Integer pk) {
		return schedulemapper.getScheduleById(pk);
	}

	@Override
	public List<Schedule> getScheduleByClasses(Classes classes) {
		return schedulemapper.getScheduleByClasses(classes);
	}

	@Override
	public List<Schedule> getScheduleBySchedule(Schedule schedule) {
		return schedulemapper.getScheduleBySchedule(schedule);
	}

	@Override
	public int updateBySchedule(Schedule schedule) {
		return schedulemapper.updateBySchedule(schedule);
	}

	@Override
	public int deleteByScheduleId(Integer pk) {
		return schedulemapper.deleteByScheduleId(pk);
	}

	@Override
	public int insertSchedule(Schedule schedule) {
		return schedulemapper.insertSchedule(schedule);
	}

	@Override
	public List<Schedule> getSchedules(Schedule schedule) {
		
		return schedulemapper.getScheduleBySchedule(schedule);
	}

	@Override
	public int cleanSchedule() {
		return schedulemapper.cleanSchedule();
	}

	@Override
	public int addSchedule(Schedule[] schs) {
		return schedulemapper.addSchedule(schs);
	}

	@Override
	public int addSch(List<Schedule> sch) {
		// TODO Auto-generated method stub
		return schedulemapper.addSch(sch);
	}

}
