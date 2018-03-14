package cn.bdqn.service;

import java.util.List;

import cn.bdqn.pojo.Room;

public interface RoomService{
	
	List<Room> getAllRoom();//查询所有的教室
	
	Room getRoomById(Integer id);//根据教室主键查询教室
	
	List<Room> getRoomByRoom(Room room);//根据教室对象查询教室
	
	int insertByRoom(Room room);//添加新教室
	
	int deleteById(Integer id);//逻辑删除一个教室
	
	int updateByRoom(Room room);//更新教室信息
}
