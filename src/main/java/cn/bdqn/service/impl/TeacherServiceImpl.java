package cn.bdqn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.mapper.TeacherMapper;
import cn.bdqn.pojo.Teacher;
import cn.bdqn.service.TeacherService;
import cn.bdqn.timetable.enums.CourseType;
import cn.bdqn.timetable.enums.WorkRole;
import cn.bdqn.timetable.ro.ClassTimeRo;
import cn.bdqn.timetable.vo.Teacher4class;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherMapper teacherMapper;
	
	@Override
	public List<Teacher> getAllTeacher() {
		return teacherMapper.getAllTeacher();
	}

	@Override
	public Teacher geTeacherById(Integer id) {
		return teacherMapper.getTeacherById(id);
	}

	@Override
	public List<Teacher> getTeacherByTeacher(Teacher teacher) {
		return teacherMapper.getTeacherByTeacher(teacher);
	}

	@Override
	public int updataByTeacher(Teacher teacher) {
		return teacherMapper.updataByTeacher(teacher);
	}

	@Override
	public int deleteById(Integer id) {
		return teacherMapper.deleteById(id);
	}

	@Override
	public int insertByTeacher(Teacher teacher) {
		return teacherMapper.insertByTeacher(teacher);
	}

	@Override
	public List<cn.bdqn.timetable.vo.Teacher> list(ClassTimeRo ctRo) {
		 List<cn.bdqn.timetable.vo.Teacher> list = new ArrayList<>();
	        list.add(new cn.bdqn.timetable.vo.Teacher("1", "王建兵", WorkRole.CourseTeacher, CourseType.JAVA));
	        list.add(new cn.bdqn.timetable.vo.Teacher("2", "徐士甲", WorkRole.CourseTeacher, CourseType.JAVA));
	        list.add(new cn.bdqn.timetable.vo.Teacher("3", "丁鹏", WorkRole.CourseTeacher, CourseType.JAVA));
	        list.add(new cn.bdqn.timetable.vo.Teacher("4", "吴智超", WorkRole.CourseTeacher, CourseType.JAVA));
	        list.add(new cn.bdqn.timetable.vo.Teacher("5", "孙子荃", WorkRole.CourseTeacher, CourseType.UI));
	        list.add(new cn.bdqn.timetable.vo.Teacher("6", "包俊文", WorkRole.CourseTeacher, CourseType.JAVA));

	        list.add(new Teacher4class("7", "阮柳"));
	        list.add(new Teacher4class("8", "朱大玲"));
	        list.add(new Teacher4class("9", "文雯"));
	        list.add(new Teacher4class("10", "罗纯"));
	        list.add(new Teacher4class("11", "汪文妮"));
	        list.add(new Teacher4class("12", "陈冠男"));

	        return list;
	}

	@Override
	public Integer getTeacherIdByName(String teacher) {
		return teacherMapper.getTeacherIdByName(teacher);
	}
	
}
