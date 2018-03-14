package cn.bdqn.mapper;

import cn.bdqn.pojo.Teacher;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {

	List<Teacher> getAllTeacher();//获取所有的老师
	
	Teacher getTeacherById(Integer id);//根据老师的主键获取一位老师
	
	List<Teacher> getTeacherByTeacher(Teacher teacher);//根据一个老师的对象查询一位老师的信息
	
	int updataByTeacher(Teacher teacher);//更新老师信息
	
	int deleteById(Integer id);//根据老师主键逻辑删除一位老师
	
	int insertByTeacher(Teacher teacher);//新增一位老师的信息  

	Teacher getContent(String con);//根据班级名称查询老师

	Teacher getContent2(String con);//根据班级名称查询教员和对应的课程
	
	Integer getTeacherIdByName(String name);
	
}