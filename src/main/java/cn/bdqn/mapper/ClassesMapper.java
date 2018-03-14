package cn.bdqn.mapper;

import cn.bdqn.pojo.Classes;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ClassesMapper {
   
	List<Classes> getAllClasses();
	
	Classes getClassesById(Integer pk);
	
	List<Classes> getClassesByClasses(Classes classes);
	
	int updateByClasses(Classes classes);
	
	int deleteByClassesId(Integer pk);

	int insertClasses(Classes classes);
	
	Integer getClassesIdByClassesName(String name);
	
}