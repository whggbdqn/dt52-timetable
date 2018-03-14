package cn.bdqn.service;

import java.util.List;
import java.util.ArrayList;

import cn.bdqn.pojo.Course;
import cn.bdqn.timetable.ro.ClassTimeRo;

import org.springframework.stereotype.Service;

import cn.bdqn.timetable.enums.CourseType;

public interface CourseService {
	
	List<Course> getAllCourse();//查询所有的课程
	
	Course getCourseById(Integer id);//根据课程主键获取课程信息
	
	List<Course> getCourseByCourse(Course course);//根据课程对象获取课程信息
	
	int insertCourse(Course course);//新增课程信息
	
	int deleteCourse(Integer id);//根据课程id逻辑删除课程信息
	
	int updateCourse(Course course);//更新课程信息

	List<cn.bdqn.timetable.vo.Course> list(ClassTimeRo ctRo);

	Integer getCourseIdByCourseName(String coursename);

}
