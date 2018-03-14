package cn.bdqn.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import cn.bdqn.pojo.Classes;
import cn.bdqn.pojo.Course;
import cn.bdqn.pojo.Room;
import cn.bdqn.pojo.Schedule;
import cn.bdqn.pojo.Teacher;
import cn.bdqn.pojo.arrs;
import cn.bdqn.service.CourseService;
import cn.bdqn.service.RoomService;
import cn.bdqn.service.TeacherService;
import cn.bdqn.service.classesservice;
import cn.bdqn.util.WeekUtil;

@Controller
public class ClassController {

	@Autowired
	private classesservice claservice;

	@Autowired
	private TeacherService teacherservice;

	@Autowired
	private CourseService courseservice;

	@Autowired
	private RoomService roomservice;

	@Autowired
	private cn.bdqn.service.scheduleservice scheduleservice;

	@RequestMapping("/all")
    @ResponseBody
    public Schedule[] getAllClass(Model model) {
    	List<Classes> allClass = claservice.getAllClasses();
    	model.addAttribute("allClass", allClass);
    	Classes[] resultclass=null;
    	scheduleservice.cleanSchedule();
    	while (resultclass==null) {
    		resultclass = claservice.defaultRule1(allClass);//每个班一周排4个课次，每个班一天在一个教室
    		resultclass = claservice.defaultRule2(resultclass);//每一天教员老师最多带两个班
    	}
    	model.addAttribute("resultclass", resultclass);
       
//    	Schedule[] schedules = new Rule3().check(resultclass);
    	Schedule[] schedules = new Schedule[56];
    	for (int i = 0; i < 7; i++) {//通过数组给课表对象添加属性
            int p = (i+1)*8;
            int min = p-8;
            
            for (int j = min; j < p; j++) {
            	Schedule ns = new Schedule();
            	if(resultclass[j]!=null){
//            	System.out.print(j+"  "+((j%8)+1)+"教室      ");
            		 DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            		Date schdate = null;
//            		System.out.print(WeekUtil.getNextday((p/8)-1)+"  ");
					try {
						schdate = format.parse(WeekUtil.getNextday((p/8)-1));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					Integer classPk = resultclass[j].getClassPk();
					Integer courseId = resultclass[j].getCourseId();
					courseId+=i;
					Integer instructorId = resultclass[j].getInstructorId();
					Integer teacherId = resultclass[j].getTeacherId();
					Random random = new Random();
		    		int ran = random.nextInt(2);
		    		Integer schteaId=0;
					
					Integer roomId = ((j%8)+1);
//					String week = WeekUtil.getWeek();
					String week = "周"+(p/8);
					//教室信息	
					ns.setRoomId(roomId);
					ns.setRoom(roomservice.getRoomById(roomId));

					//班级信息
					ns.setClassesId(classPk);
					Classes classesById = claservice.getClassesById(classPk);
					ns.setClasses(classesById);
//					int id=courseId+1;
//					classesById.setCourseId(id);
//					claservice.updateByClasses(classesById);
					
					//教师信息
					if(ran<1){
		    			schteaId=instructorId;
						}else{
		    			schteaId=teacherId;
		    			}
					ns.setTeacherId(schteaId);		
					Teacher geTeacherById = teacherservice.geTeacherById(schteaId);
					ns.setTeacher(geTeacherById);
					//课程信息
					
					Course courseById = courseservice.getCourseById(courseId);
					ns.setCourse(courseById);
					ns.setCourseId(courseId);
					
					//下周日期
					ns.setSchDate(schdate);
					//下周周数
					ns.setWeek(week);
					//设置一天中的时段
					ns.setSchTime("AM");
            	}
            	schedules[j]=ns;
                            }
//            System.out.println("周"+(p/8)+"");
            
                  }
    	
    	Schedule[] sch = new Schedule[168];
    	for(int i=0;i<schedules.length;i++){
    		if(schedules[i]!=null){
    		Schedule scham = new Schedule();
    		Schedule schpm = new Schedule();
    		Schedule schem = new Schedule();
    		
    		Integer classesId = schedules[i].getClassesId();
    		Classes classes = schedules[i].getClasses();
    		Integer courseId = schedules[i].getCourseId();
    		Course course = schedules[i].getCourse();
    		Integer roomId = schedules[i].getRoomId();
    		Room room = schedules[i].getRoom();
    		Integer teacherId = schedules[i].getTeacherId();
    		Teacher teacher = schedules[i].getTeacher();
    		String week = schedules[i].getWeek();
    		Date schDate = schedules[i].getSchDate();
    		
    		scham.setClassesId(classesId);
    		scham.setClasses(classes);
    		scham.setCourseId(courseId);
    		scham.setCourse(course);
    		scham.setRoomId(roomId);
    		scham.setRoom(room);
    		scham.setTeacherId(teacherId);
    		scham.setTeacher(teacher);
    		scham.setWeek(week);
    		scham.setSchTime("AM");
    		scham.setSchDate(schDate);
    		
    		schpm.setClassesId(classesId);
    		schpm.setClasses(classes);
    		schpm.setCourseId(courseId);
    		schpm.setCourse(course);
    		schpm.setRoomId(roomId);
    		schpm.setRoom(room);
    		schpm.setTeacherId(teacherId);
    		schpm.setTeacher(teacher);
    		schpm.setWeek(week);
    		schpm.setSchTime("PM");
    		schpm.setSchDate(schDate);
    		
//    		schem.setClassesId(0);
//    		schem.setCourseId(0);
//    		schem.setRoomId(0);
//    		schem.setTeacherId(0);
    		schem.setSchTime("EM");
    		schem.setSchDate(schDate);
    		schem.setWeek(week);
    		
    		Integer instructorId=0;
    		Integer teacherId2=0;
    		if(resultclass[i]!=null){
    		 instructorId = resultclass[i].getInstructorId();
    		 teacherId2 = resultclass[i].getTeacherId();
    		}
    	if(scham!=null&&scham.getSchTime()!=null){
    		if(instructorId.equals(teacherId)){
//    			System.out.println(instructorId+"+++"+teacherId);
    			//上午正课 下午设为自习
    			//设置下午上课老师为班主任
    			schpm.setTeacherId(teacherId2);
    			Teacher geTeacherById = teacherservice.geTeacherById(teacherId2);
    			schpm.setTeacher(geTeacherById);
    			schpm.setCourseId(97);
    			Course courseById = courseservice.getCourseById(97);
    			schpm.setCourse(courseById);
    		}else{
    			if(schDate!=null){
//    			System.out.println("上午"+scham+"下午"+schpm);
    			scham.setTeacherId(teacherId2);
    			Teacher geTeacherById = teacherservice.geTeacherById(teacherId2);
    			scham.setTeacher(geTeacherById);
    			scham.setCourseId(97);
    			Course courseById = courseservice.getCourseById(97);
    			scham.setCourse(courseById);
    			
    			if(schedules[i]!=null){
    			schpm.setTeacherId(instructorId);
    			Teacher geTeacherById2 = teacherservice.geTeacherById(instructorId);
    			schpm.setTeacher(geTeacherById2);
    			}
    			}
    		}
    	}
    		sch[i*3]=scham;
    		sch[((i*3)+1)]=schpm;
    		sch[((i*3)+2)]=schem;
    		}
    	}
    	
//    	for(int i=0;i<sch.length;i++){
//    		Schedule schedule = new Schedule();
//    		schedule.setClassesId(0);
//    		schedule.setCourseId(1);
//    		schedule.setRoomId(0);
//    		schedule.setTeacherId(0);
//    		schedule.setSchTime("全天");
//    		schedule.setSchDate(new Date());
//    		schedule.setWeek("空闲");
//    		int j=0;
//			if(sch[i]!=null){
//				if(!("晚上".equals(sch[i].getSchDate()))){
//				j=scheduleservice.insertSchedule(sch[i]);
//				}
//			}else{
//				scheduleservice.insertSchedule(schedule);
//			}
//		}
    	scheduleservice.addSchedule(sch);
    	return sch;
//    	return "class"; 
    }
	
	@RequestMapping("/write")
	@ResponseBody
	public boolean setsch(@RequestBody List<arrs> arrys ) {
		scheduleservice.cleanSchedule();
		boolean is = true;
		List<Schedule> sch = new ArrayList<Schedule>(); 
	for (arrs arrs : arrys) {
		Schedule schedule = new Schedule();
//		System.out.println(arrs);
		String clazzname = arrs.getClazz();
		Integer classesId = claservice.getClassesIdByClassesName(clazzname);
		String coursename = arrs.getCourse();
		Integer courseId = courseservice.getCourseIdByCourseName(coursename);
		Date date = arrs.getDate();
		String roomId = arrs.getRoom();
		String schTime = arrs.getSchtime();
		String teacher = arrs.getTeacher();
		Integer teacherId = teacherservice.getTeacherIdByName(teacher);
		String week = arrs.getWeek();
		
		schedule.setRoomId(Integer.parseInt(roomId));
		schedule.setSchTime(schTime);
		schedule.setClassesId(classesId);
		schedule.setSchDate(date);
		schedule.setCourseId(courseId);
		schedule.setTeacherId(teacherId);
		schedule.setWeek(week);
		
		sch.add(schedule);
	}
	
	int addSch = scheduleservice.addSch(sch);
	if(addSch==0){
		is=false;
		}
//		for (Schedule schedule : sch) {
//			System.out.println(schedule);
//			int insertSchedule = scheduleservice.insertSchedule(schedule);
//			if(insertSchedule==0){
//			is=false;
//			}
//		}
		return is;
	}
	
}

