package cn.bdqn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.mapper.RoomMapper;
import cn.bdqn.pojo.Room;
import cn.bdqn.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	private RoomMapper roomMapper;
	
	@Override
	public List<Room> getAllRoom() {
		return roomMapper.getAllRoom();
	}

	@Override
	public Room getRoomById(Integer id) {
		return roomMapper.getRoomById(id);
	}

	@Override
	public List<Room> getRoomByRoom(Room room) {
		return roomMapper.getRoomByRoom(room);
	}

	@Override
	public int insertByRoom(Room room) {
		return roomMapper.insertByRoom(room);
	}

	@Override
	public int deleteById(Integer id) {
		return roomMapper.deleteById(id);
	}

	@Override
	public int updateByRoom(Room room) {
		return roomMapper.updateByRoom(room);
	}

}
