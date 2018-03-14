package cn.bdqn.controller;

import java.util.ArrayList;
import java.util.List;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bdqn.pojo.Teacher;
import cn.bdqn.service.HandleClassesService;


@Controller
public class HandleClassController {
	
	@Autowired
	private HandleClassesService hcservice;
	
	//登陆
	@RequestMapping("/login")
	public String login(){
		return "main";
	}
 	
	//进入view页面
	@RequestMapping("/view")
	public String getViewPage(){
		return "view";
	}
	
	//进入order页面
	@RequestMapping("/order")
	public String getOrderPage(){
		return "order";
	}
	
	@RequestMapping("/auto")
	public String getAutoPage(){
		return "auto";
	}
	
	@RequestMapping("/viewSchedule")
	@ResponseBody
	public List viewSchedule(){

		return hcservice.viewSchedule();
	}

	@RequestMapping("content")
	@ResponseBody
	public List<Teacher> getContent(String con){
		Teacher teacher = hcservice.getContent(con);
		Teacher teacher2 = hcservice.getContent2(con);
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		list.add(teacher2);
		list.add(teacher);
		return list;
		
	}
	
//	@RequestMapping("getCourse")
//	@ResponseBody
//	public Teacher getCourse(String con){
//		Teacher teacher = hcservice.getCourse(con);
//		System.out.println(teacher);
//		return teacher;
//	}
	
}
