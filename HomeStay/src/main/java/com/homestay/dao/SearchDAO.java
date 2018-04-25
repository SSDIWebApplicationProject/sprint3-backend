package com.homestay.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import com.homestay.connection.ConnectionUtil;
import com.homestay.model.Room;
import com.homestay.model.Search;




@Repository
@Configuration
@EnableAutoConfiguration
public class SearchDAO implements ISearchDAO{
	@Autowired
	ConnectionUtil Conn;
	private int noOfGuestsUI;
	private String cityName;
	 
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public ArrayList<Room>  getRoom(Search search) {
		 ArrayList<Room> rooms=new ArrayList<>();
		 PreparedStatement ps=null;
		 Connection con;
	    try{  
		 con= (Connection) Conn.getConnection(); 
		 setNoOfGuestsUI(search.getNoofGuests());
		 setCityName(search.getCity());
		 
		ps=con.prepareStatement("select * from room where maxPeople="+search.getNoofGuests()); 
		
		ResultSet rs=ps.executeQuery(); 
		while (rs.next()) {
			int id = rs.getInt("room_id");
			String roomName = rs.getString("roomName");
			String distance = rs.getString("distance");
			int bedroom = rs.getInt("bedroom");
			int bathroom = rs.getInt("bathroom");
			int maxPeople = rs.getInt("maxPeople");
			int cityId = rs.getInt("cityId");
			String roomUrl = rs.getString("roomurl");
			int costPerDay = rs.getInt("CostPerDay");
			Room room = new Room();
			room.setId(id);
			room.setDistance(distance);
			room.setMaxpeople(maxPeople);
			room.setNoBathroom(bathroom);
			room.setNoBedroom(bedroom);
			room.setRoomName(roomName);
			room.setRoomUrl(roomUrl);
			room.setCityId(cityId);
			room.setCostPerDay(costPerDay);
			rooms.add(room);
		    }
		  }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
		return rooms;
	}
	 
	 public int getNoOfGuestsUI() {
		return noOfGuestsUI;
	}

	public void setNoOfGuestsUI(int noOfGuestsUI) {
		this.noOfGuestsUI = noOfGuestsUI;
	}

	public ArrayList<Room>  getRoomDetails() {
		 ArrayList<Room> rooms=new ArrayList<>();
		 PreparedStatement ps=null;
		 Connection con;
	    try{  
		 con= (Connection) Conn.getConnection();  
		 
		ps=con.prepareStatement("select * from room where maxPeople= "+getNoOfGuestsUI()+ " and IsBooked=0 and cityId in (select cityId from City where CityName = '"+getCityName()+"')"); 
		
		ResultSet rs=ps.executeQuery(); 
		while (rs.next()) {
			int id = rs.getInt("room_id");
			String roomName = rs.getString("roomName");
			String distance = rs.getString("distance");
			int bedroom = rs.getInt("bedroom");
			int bathroom = rs.getInt("bathroom");
			int maxPeople = rs.getInt("maxPeople");
			int cityId = rs.getInt("cityId");
			int costPerDay = rs.getInt("CostPerDay");
			String roomUrl = rs.getString("roomurl");
			Room room = new Room();
			room.setId(id);
			room.setDistance(distance);
			room.setMaxpeople(maxPeople);
			room.setNoBathroom(bathroom);
			room.setNoBedroom(bedroom);
			room.setRoomName(roomName);
			room.setRoomUrl(roomUrl);
			room.setCityId(cityId);
			room.setCostPerDay(costPerDay);
			rooms.add(room);
			
		    }
		  }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
		return rooms;
	}

}

