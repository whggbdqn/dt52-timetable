package cn.bdqn.pojo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class arrs {

	private String room;
	private String clazz;
	private String teacher;
	private String course;
	@JSONField(format="yyyy-MM-ddTHH:mm.SSSZ") 
	private Date date;
	private String schtime;
	private String week;
	
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSchtime() {
		return schtime;
	}
	public void setSchtime(String schtime) {
		this.schtime = schtime;
	}

	
}
