package cn.bdqn.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GetMonday {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		
		Date date = new Date();
		
		cal.setTime(date);
		
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd EE");  
		
		ArrayList<Date> list = new ArrayList<Date>(); 
		ArrayList<String> list2 = new ArrayList<String>();
		for(int i = 0 ; i < 7; i++){
			cal.add(Calendar.DAY_OF_WEEK, 1);
			date = cal.getTime();
			String format = df.format(date);
			list.add(date);
			list2.add(format);
		}
		for (Date date2 : list) {
			System.out.println("date2:"+date2);
		}
		for (String string : list2) {
			System.out.println("string:"+string);
		}
	}
	
	//得到指定日期以后的一周
	public List<String> getMonday(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		//固定格式
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd EE");  
		
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i = 0 ; i < 7; i++){
			cal.add(Calendar.DAY_OF_WEEK, 1);
			date = cal.getTime();
			
			String format = df.format(date);
			list.add(format);
			
		}
		return list;
	}
}
