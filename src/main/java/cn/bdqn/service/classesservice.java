package cn.bdqn.service;

import java.util.List;




import org.springframework.stereotype.Service;

import cn.bdqn.pojo.Classes;

public interface classesservice {

	List<Classes> getAllClasses();
	
	Classes getClassesById(Integer pk);
	
	List<Classes> getClassesByClasses(Classes classes);
	
	int updateByClasses(Classes classes);
	
	int deleteById(Integer pk);

	int insertClasses(Classes classes);
	
	Classes[] defaultRule1(List<Classes> allClass);
	
	Classes[] defaultRule2(Classes[] resultclass);

	Integer getClassesIdByClassesName(String clazzname);
	
	
}
