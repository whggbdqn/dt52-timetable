package cn.bdqn.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bdqn.pojo.Room;
import cn.bdqn.pojo.Schedule;
import cn.bdqn.service.HandleClassesService;
import cn.bdqn.util.GetMonday;

@Controller
public class ExportController {

	@Autowired
	private HandleClassesService hcservice;
	
	@RequestMapping("export")
	public void export(HttpServletResponse response) throws Exception{
		System.out.println("开始导出");
		
		//创建表并命名表
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		XSSFSheet createSheet = xssfWorkbook.createSheet("sheet1");
		
//		 CellStyle cellStyle = xssfWorkbook.createCellStyle();
//         CreationHelper creationHelper = xssfWorkbook.getCreationHelper();
//         
//         cellStyle.setDataFormat(creationHelper.createDataFormat()
//                 .getFormat("yyyy-MM-dd"));
		//设置列宽
		createSheet.setColumnWidth(11, 11*256);
		
		//创建表头
		XSSFRow firstRow = createSheet.createRow(0);
		XSSFRow secRow = createSheet.createRow(1);
		firstRow.createCell(0).setCellValue("日期");
		firstRow.createCell(1).setCellValue("教室");
		firstRow.createCell(2).setCellValue("上午8:30-12:30");
		firstRow.createCell(5).setCellValue("下午2：00-6：00");
		firstRow.createCell(8).setCellValue("晚上6:30-8:30");
		
		secRow.createCell(2).setCellValue("班级名称");
		secRow.createCell(3).setCellValue("教师姓名");
		secRow.createCell(4).setCellValue("课程内容");
		secRow.createCell(5).setCellValue("班级名称");
		secRow.createCell(6).setCellValue("教师姓名");
		secRow.createCell(7).setCellValue("课程内容");
		secRow.createCell(8).setCellValue("班级名称");
		secRow.createCell(9).setCellValue("教师姓名");
		secRow.createCell(10).setCellValue("课程内容");
		
		// 合并单元格  
		CellRangeAddress cra =new CellRangeAddress(0, 1, 0, 0);// 起始行, 终止行, 起始列, 终止列  
		CellRangeAddress cra1 =new CellRangeAddress(0, 1, 1, 1);
		CellRangeAddress cra2 =new CellRangeAddress(0, 0, 2, 4);
		CellRangeAddress cra3 =new CellRangeAddress(0, 0, 5, 7);
		CellRangeAddress cra4 =new CellRangeAddress(0, 0, 8, 10);
		CellRangeAddress cra5 = new CellRangeAddress(2,9,0,0);
		CellRangeAddress cra6 = new CellRangeAddress(10,17,0,0);
		CellRangeAddress cra7 = new CellRangeAddress(18,25,0,0);
		CellRangeAddress cra8 = new CellRangeAddress(26,33,0,0);
		CellRangeAddress cra9 = new CellRangeAddress(34,41,0,0);
		CellRangeAddress cra10 = new CellRangeAddress(42,49,0,0);
		CellRangeAddress cra11 = new CellRangeAddress(50,57,0,0);
		createSheet.addMergedRegion(cra);
		createSheet.addMergedRegion(cra1);
		createSheet.addMergedRegion(cra2);
		createSheet.addMergedRegion(cra3);
		createSheet.addMergedRegion(cra4);
		createSheet.addMergedRegion(cra5);
		createSheet.addMergedRegion(cra6);
		createSheet.addMergedRegion(cra7);
		createSheet.addMergedRegion(cra8);
		createSheet.addMergedRegion(cra9);
		createSheet.addMergedRegion(cra10);
		createSheet.addMergedRegion(cra11);
		
		firstRow.setHeight((short) (25 * 20));// 20 为一个单位长度
		secRow.setHeight((short)(25*20));
		
		
		//创建行并填入机房信息
		for(int i = 2; i < 58; i++){
			XSSFRow createRow = createSheet.createRow(i);
			if((i+6)% 8 == 0){
				createRow.createCell(1).setCellValue("一机房");
			}
			if((i+6)% 8 == 1){
				createRow.createCell(1).setCellValue("二机房");
			}
			if((i+6)% 8 == 2){
				createRow.createCell(1).setCellValue("三机房");
			}
			if((i+6)% 8 == 3){
				createRow.createCell(1).setCellValue("四机房");
			}
			if((i+6)% 8 == 4){
				createRow.createCell(1).setCellValue("五机房");
			}
			if((i+6)% 8 == 5){
				createRow.createCell(1).setCellValue("六机房");
			}
			if((i+6)% 8 == 6){
				createRow.createCell(1).setCellValue("七机房");
			}
			if((i+6)% 8 == 7){
				createRow.createCell(1).setCellValue("八机房");
			}
			
		}
		
		List<Schedule> list = hcservice.viewSchedule();
		Date monday = null;
		//创建并填充单元格
		for (Schedule schedule : list) {
			//得到日期对应的是周几，确定位于哪个大的单元格
			Date date = schedule.getSchDate();  
		    Calendar cal = Calendar.getInstance();  
		    //cal.setFirstDayOfWeek(Calendar.MONDAY);//设置周一为一周的第一天  
		    cal.setTime(date);
		    //确定位于哪一行
		    int weeknum = cal.get(Calendar.DAY_OF_WEEK);//得到周几
		    weeknum = weeknum -1;
		    System.err.println("weeknum:"+weeknum);
		    
		    if(weeknum == 0){
		    	weeknum = 7;
		    }
		    
		    if(monday == null){
			   
			    cal.add(Calendar.DAY_OF_MONTH, 0-weeknum);
			    monday = cal.getTime();
			}
		    Integer roomId = schedule.getRoomId();//得到教室
			String schTime = schedule.getSchTime();
			
			//确定行号
			int row = weeknum*8 + roomId -7;
			System.err.println("row:"+row);
		    //列号
			int colcl = 0;//班级
			int colt = 0;//老师
			int colc = 0;//课程
			int cold = 0;//时间
				if("AM".equals(schTime)){
					
					colcl = 2;//班级
					colt = 3;//老师
					colc = 4;//课程
					
				}else if("PM".equals(schTime)){
					colcl = 5;//班级
					colt = 6;
					colc = 7;
				}else {
					colcl = 8;//班级
					colt = 9;
					colc = 10;
				}			
			
			XSSFRow xrow = createSheet.getRow(row);
			
			XSSFCell cellr = xrow.createCell(colcl);
			XSSFCell cellt = xrow.createCell(colt);
			XSSFCell cellc = xrow.createCell(colc);
			
			
			cellr.setCellValue(schedule.getClasses().getClassName());
			cellt.setCellValue(schedule.getTeacher().getName());
			cellc.setCellValue(schedule.getCourse().getCourseContent());
			
			
          
            //System.out.println(schedule.getSchDate());
		}
		
		
		
		//write date
		int d = 0;
		GetMonday mon = new GetMonday();
		List<String> list2 = mon.getMonday(monday);
		for(int i = 0; i < 7; i++){
			d = 2 + i*8;
			this.writeDate(list2.get(i), createSheet, d);
		}
		
		
		response.setContentType("application/vnd.ms-excel");
		String file = "schedule.xlsx";
		// 设置文件MIME类型
        response.setContentType("application/vnd.ms-excel");
        // 设置Content-Disposition
        response.setHeader("Content-Disposition", "attachment;filename=\""
                + new String(file.getBytes("utf8"), "ISO8859-1") + "\"");

        OutputStream out = response.getOutputStream();
        xssfWorkbook.write(out);

        xssfWorkbook.close();
        out.flush();
        out.close();

        System.out.println("done");
		
		
	}
	
	/**
	 * 
	 * @param date Date
	 * @param createSheet 
	 * @param cellStyle
	 * @param rowIndex
	 */
	private void writeDate(String date,XSSFSheet createSheet,int rowIndex){
		 
          XSSFRow xrow = createSheet.getRow(rowIndex);
          XSSFCell celld = xrow.createCell(0);//日期
         
          celld.setCellValue(date);
	}
	
}
