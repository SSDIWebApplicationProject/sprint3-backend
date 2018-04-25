package com.homestay.dao;

import java.util.ArrayList;

import com.homestay.model.Room;
import com.homestay.model.Search;

public interface ISearchDAO {
	public ArrayList<Room>  getRoom(Search search);
	public ArrayList<Room>  getRoomDetails();
}
