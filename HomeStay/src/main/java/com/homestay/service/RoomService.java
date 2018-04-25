package com.homestay.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homestay.dao.ISearchDAO;
import com.homestay.model.Room;
import com.homestay.model.Search;


@Service
public class RoomService implements IRoomService{
	@Autowired
	ISearchDAO searchDao;
	
public ArrayList<Room> getRoom(Search search) {
		ArrayList<Room> roomDetails=new ArrayList<>();
		roomDetails=searchDao.getRoom(search);
		return roomDetails;
	}
	
	public ArrayList<Room> getRoomDetails() {
		ArrayList<Room> roomDetails=new ArrayList<>();
		roomDetails=searchDao.getRoomDetails();
		
		return roomDetails;
	}
	

}
