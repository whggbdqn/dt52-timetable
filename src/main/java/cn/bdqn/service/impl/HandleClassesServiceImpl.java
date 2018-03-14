package cn.bdqn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.mapper.ClassesMapper;
import cn.bdqn.mapper.CourseMapper;
import cn.bdqn.mapper.RoomMapper;
import cn.bdqn.mapper.ScheduleMapper;
import cn.bdqn.mapper.TeacherMapper;
import cn.bdqn.pojo.Classes;
import cn.bdqn.pojo.Room;
import cn.bdqn.pojo.Schedule;
import cn.bdqn.pojo.Teacher;
import cn.bdqn.service.HandleClassesService;
@Service
public class HandleClassesServiceImpl implements HandleClassesService {

	@Autowired
	private ClassesMapper clamapper;
	
	@Autowired
	private TeacherMapper teacherMapper;
	
	@Autowired
	private ScheduleMapper schedulemapper;
	
	@Autowired
	private RoomMapper roomMapper;
	
	@Autowired
	private CourseMapper courseMapper;
	
	@Override
	public List<Teacher> getAllTeacher() {
		return teacherMapper.getAllTeacher();
	}

	@Override
	public List<Classes> getAllClasses() {
		
		return clamapper.getAllClasses();
	}

	@Override
	public Classes getInstructor(Integer cla) {
		// TODO Auto-generated method stub
		return clamapper.getClassesById(cla);
	}

	@Override
	public List<Room> getRoom() {
		// TODO Auto-generated method stub
		return roomMapper.getAllRoom();
	}

	@Override
	public List<Schedule> getSchedule() {
		// TODO Auto-generated method stub
		return schedulemapper.getallSchedule();
	}

	@Override
	public List viewSchedule() {

		return schedulemapper.viewSchedule();
	}

	@Override
	public Teacher getContent(String con) {
		// TODO Auto-generated method stub
		return teacherMapper.getContent(con);
	}

	@Override
	public Teacher getContent2(String con) {
		// TODO Auto-generated method stub
		return teacherMapper.getContent2(con);
	}

	

	
}
