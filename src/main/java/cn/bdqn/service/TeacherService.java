package cn.bdqn.service;

import java.util.List;

import cn.bdqn.pojo.Teacher;
import cn.bdqn.timetable.ro.ClassTimeRo;

public interface TeacherService {
	List<Teacher> getAllTeacher();//获取所有的老师
	
	Teacher geTeacherById(Integer id);//根据老师的主键获取一位老师
	
	List<Teacher> getTeacherByTeacher(Teacher teacher);//根据一个老师的对象查询一位老师的信息
	
	int updataByTeacher(Teacher teacher);//更新老师信息
	
	int deleteById(Integer id);//根据老师主键逻辑删除一位老师
	
	int insertByTeacher(Teacher teacher);//新增一位老师的信息

	List<cn.bdqn.timetable.vo.Teacher> list(ClassTimeRo ctRo);

	Integer getTeacherIdByName(String teacher);
}
