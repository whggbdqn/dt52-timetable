package cn.bdqn.mapper;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.bdqn.pojo.Classes;
import cn.bdqn.pojo.Teacher;

public class ClassesMapperTest {

	private ClassesMapper bean;
	private TeacherMapper bean2;

	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext Context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
		bean = Context.getBean(ClassesMapper.class);
		bean2 = Context.getBean(TeacherMapper.class);
	}


	@Test
	public void testGetAllClasses() {
		List<Classes> allClasses = bean.getAllClasses();
		for (Classes classes : allClasses) {
			System.out.println(classes);
		}
	}
	
	@Test
	public void testGetContent(){
		String s = "DT52";
		Teacher teacher = bean2.getContent(s);
		System.out.println(teacher);
//		assertNull(teacher);
	}
	
	@Test
	public void testGetAllTeacher() {
		List<Teacher> allClasses = bean2.getAllTeacher();
		for (Teacher classes : allClasses) {
			System.out.println(classes);
		}
	}

	
}
