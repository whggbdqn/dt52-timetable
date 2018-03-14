package cn.bdqn.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.mapper.ClassesMapper;
import cn.bdqn.service.classesservice;
import cn.bdqn.service.rule.Rule2;
import cn.bdqn.pojo.Classes;

@Service
public class classesserviceimpl implements classesservice{

	@Autowired
	private ClassesMapper clamapper;
	
	public List<Classes> getAllClasses() {
		return clamapper.getAllClasses();
	}
	
	public Classes getClassesById(Integer pk){
		return clamapper.getClassesById(pk);
	}
	
	public List<Classes> getClassesByClasses(Classes classes){
		return clamapper.getClassesByClasses(classes);
	}
	
	public int updateByClasses(Classes classes){
		return clamapper.updateByClasses(classes);
	}
	
	public int deleteById(Integer pk){
		return clamapper.deleteByClassesId(pk);
		
	}

	public int insertClasses(Classes classes){
		return clamapper.insertClasses(classes);
	}
	//理想化条件：一共8个机房，一周一共排56个班次，一周内所有班都可以排上，且不考虑上下周关系
	//初始化条件1：每个班一周排4个课次，每一天教员老师最多带两个班
	public Classes[] defaultRule1(List<Classes> allClass) {
    	boolean success = true;
    	Random random = new Random();
    	Classes[] resultclass = new Classes[56];//设置有8个机房一周7天共56个课次
    	resultclass=new Rule2().check(allClass);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < allClass.size(); j++) {
                int ran = random.nextInt(resultclass.length);
                if (resultclass[ran]!=null) {
                    j--;
                    continue;
                }
//                Classes nClass = new Classes();
//                nClass.setDr(allClass.get(j).getDr());
//                nClass.setClassName(allClass.get(j).getClassName());
//                nClass.setStuNum(allClass.get(j).getStuNum());
//                nClass.setMajor(allClass.get(j).getMajor());
//                nClass.setClassTeacher(allClass.get(j).getClassTeacher());
//                nClass.setInstructor(allClass.get(j).getInstructor());
//                nClass.setTime(allClass.get(j).getTime());
//                nClass.setDr(allClass.get(j).getDr());
//                resultclass[ran]=nClass;//allClass.get(j);
                if(allClass.get(j).getStuNum()<=30){
                resultclass[ran]=allClass.get(j);
                }
            }
            
        }
      //将每周重复的班级置空，并将其放入list储存
        List<Classes> list = new ArrayList<Classes>();
        for (int i = 0; i < 7; i++) {
            int p = (i+1)*8;//设置效验范围每周
            int min = p-8;
            for (int j = min; j < p; j++) {
                if (resultclass[j]!=null) {
                    for (int j2 = j+1; j2 <p ; j2++) {
                        if (resultclass[j2]!=null) {
                            if (resultclass[j2]==resultclass[j]) {
                                list.add(resultclass[j2]);//将重复的班级存入list集合
                                resultclass[j2]=null;//重复的班级置空
                            }
                        }
                    }
                }
            }
        }
        //获取所有位置里的空位，并在满足每天不重复的情况下将存储中的班级排完
        List<Integer> nullList = new ArrayList<Integer>();
        for (int i = 0; i < resultclass.length; i++) {
            if (resultclass[i]==null) {//当数组元素为空将下标添加到nulllist集合
                nullList.add(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {//通过nulllist中存的下标将重复的课次重新排
            for (int j = 0; j < nullList.size(); j++) {
                int p =nullList.get(j);//获取空闲课次的下标
                int max;
                int min;
                if (p==0) {//对课次所在的星期进行判断，读取对应一天所有课次下标
                    max=8;
                    min=0;
                }else if (p%8==0) {
                    max=p;
                    min=max-8;
                }else{
                    max = (p/8+1)*8;
                    min = max-8;
                }
                boolean bool = true;//判断标记
                for (int k = min; k < max; k++) {
                    if (resultclass[k]!=null) {//当读到的课次不为空时
                        if (resultclass[k]==list.get(i)) {//如果课次重复标记设为f
                            bool = false;
                        }
                    }
                }
                if (!bool) {//课次不重复
                    if (j==nullList.size()-1) {//课次不重复且排到最后一个下标则判断排课失败
                        success=false;
                    }
                    continue;
                }else{
                    nullList.remove(j);//清空赋值下标
                    resultclass[p]=list.get(i);//将不重复的课次放入课表中
                    break;
                }
            }
        }
    
//        new Rule1().checkAll(resultclass);
        
        if (!success) {//判断运行是否成功
            resultclass=null;
        }
		return resultclass;
	}

	//初始化规则2：
	public Classes[] defaultRule2(Classes[] resultclass) {
		boolean success = true;
		  List<Classes> list = new ArrayList<Classes>();
      for (int i = 0; i < 7; i++) {//检查每天老师上课的是否超过2次如果超过则将其置空
      int p = (i+1)*8;
      int min = p-8;
      for (int j = min; j < p; j++) {
          if (resultclass[j]!=null) {//查询有不为空的课次
              for (int j2 = j+1; j2 <p ; j2++) {
                  if (resultclass[j2]!=null) {//查询有不为空的课次
                	  System.out.println(resultclass[j]+":"+resultclass[j2]);
                      if (resultclass[j2].getInstructorId().equals(resultclass[j].getInstructorId())) {
                      	//检查老师是否在一天内出现在两个教室
                      	for (int k = j2+1; k < p; k++) {
                              if (resultclass[k]!=null) {
                                  if (resultclass[k].getInstructorId().equals(resultclass[j].getInstructorId())) {
                                  	//检查老师是否在一天内出现在三个教室，出现则添加到list并置空
                                  	list.add(resultclass[k]);
                                      resultclass[k]=null;
                                  } 
                              }
                          }
                      }
                  }
              }
          }
      }
  }
  //获取所有位置里的空位，并在满足每天不重复和一天老师最多只带两个班级的情况下将存储中的班级排完
  List<Integer> nullList = new ArrayList<Integer>();
  for (int i = 0; i < resultclass.length; i++) {
      if (resultclass[i]==null) {
          nullList.add(i);
      }
  }
  for (int i = 0; i < list.size(); i++) {
      for (int j = 0; j < nullList.size(); j++) {
          int p =nullList.get(j);
          int max;
          int min;
          if (p==0) {
              max=8;
              min=0;
          }else if (p%8==0) {
              max=p;
              min=max-8;
          }else{
              max = (p/8+1)*8;
              min = max-8;
          }
          boolean bool = true;
          for (int k = min; k < max; k++) {//一天内的课次
              if (resultclass[k]!=null) {
                  if (resultclass[k]==list.get(i)) {
                      bool = false;
                  }
                  if (resultclass[k].getInstructorId().equals(list.get(i).getInstructorId())) {
                      for (int k2 = k+1; k2 < max; k2++) {
                          if (resultclass[k2]!=null) {
                              if (resultclass[k2].getInstructorId().equals(list.get(i).getInstructorId())) {
                                  bool=false;
                              }
                          }
                      }
                  }  
              }
          }
          if (!bool) {
              if (j==nullList.size()-1) {
                  success=false;
              }
              continue;
          }else{
              nullList.remove(j);
              resultclass[p]=list.get(i);
              break;
          }
      }
  }
		
//		Classes[] resultclass2 = new Classes[56];
//		System.arraycopy(resultclass, 0, resultclass2, 0, 56);
//		resultclass2 = (Classes[])resultclass.clone();

		return resultclass;
	}

	@Override
	public Integer getClassesIdByClassesName(String clazzname) {
		return clamapper.getClassesIdByClassesName(clazzname);
	}
}
