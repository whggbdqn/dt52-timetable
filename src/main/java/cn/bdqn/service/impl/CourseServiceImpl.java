package cn.bdqn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.mapper.CourseMapper;
import cn.bdqn.pojo.Course;
import cn.bdqn.service.CourseService;
import cn.bdqn.timetable.enums.CourseType;
import cn.bdqn.timetable.ro.ClassTimeRo;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseMapper courseMapper;
	
	@Override
	public List<Course> getAllCourse() {
		return courseMapper.getAllCourse();
	}

	@Override
	public Course getCourseById(Integer id) {
		return courseMapper.getCourseById(id);
	}

	@Override
	public List<Course> getCourseByCourse(Course course) {
		return courseMapper.getCourseByCourse(course);
	}

	@Override
	public int insertCourse(Course course) {
		return courseMapper.insertCourse(course);
	}

	@Override
	public int deleteCourse(Integer id) {
		return courseMapper.deleteCourse(id);
	}

	@Override
	public int updateCourse(Course course) {
		return courseMapper.updateCourse(course);
	}

	@Override
	public List<cn.bdqn.timetable.vo.Course> list(ClassTimeRo ctRo) {
		List<cn.bdqn.timetable.vo.Course> list = new ArrayList<>();
		list.add(new cn.bdqn.timetable.vo.Course("1", "JAVA", CourseType.JAVA));
		list.add(new cn.bdqn.timetable.vo.Course("2", "UI", CourseType.UI));
        list.add(new cn.bdqn.timetable.vo.Course("3", "COT", CourseType.COT));
        list.add(new cn.bdqn.timetable.vo.Course("4", "自习课", CourseType.SST));
        list.add(new cn.bdqn.timetable.vo.Course("5", "面试", CourseType.COT));
        return list;
	}

	@Override
	public Integer getCourseIdByCourseName(String coursename) {
		return courseMapper.getCourseIdByCourseName(coursename);
	}



}
