package cn.bdqn.mapper;

import cn.bdqn.pojo.Course;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CourseMapper {

	List<Course> getAllCourse();//查询所有的课程
	
	Course getCourseById(Integer id);//根据课程主键获取课程信息
	
	List<Course> getCourseByCourse(Course course);//根据课程对象获取课程信息
	
	int insertCourse(Course course);//新增课程信息
	
	int deleteCourse(Integer id);//根据课程id逻辑删除课程信息
	
	int updateCourse(Course course);//更新课程信息  

	Integer getCourseIdByCourseName(String coursename);
}