package com.homestay.service;

import java.util.ArrayList;

import com.homestay.model.Room;
import com.homestay.model.Search;

public interface IRoomService {
	
	public ArrayList<Room> getRoom(Search search);
	public ArrayList<Room> getRoomDetails();
}
