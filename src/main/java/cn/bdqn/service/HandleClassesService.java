package cn.bdqn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.bdqn.pojo.Classes;
import cn.bdqn.pojo.Room;
import cn.bdqn.pojo.Schedule;
import cn.bdqn.pojo.Teacher;

public interface HandleClassesService {
	
	List<Teacher> getAllTeacher();
	
	List<Classes> getAllClasses();

	Classes getInstructor(Integer cla);

	List<Room> getRoom();
	
	List<Schedule> getSchedule();
	
	List viewSchedule();

	Teacher getContent(String con);
	
	Teacher getContent2(String con);
	
	
	
}
