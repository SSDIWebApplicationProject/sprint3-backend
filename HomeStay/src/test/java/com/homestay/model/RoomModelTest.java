package com.homestay.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RoomModelTest {

	private  String expected_roomName="Room1";
	private  String expected_distance="500";
	private  int expected_noBedroom=2;
	private  int expected_maxpeople=2;
	private  int expected_cityId=3;
	private  String expected_roomUrl="/api/rooms";
	private Room room;
	
	@Before
	public void setRoomDetails()
	{
		room =new Room();
		room.setRoomName("Room1");
		room.setDistance("500");
		room.setNoBathroom(2);
		room.setMaxpeople(2);
		room.setCityId(3);
		room.setRoomUrl("/api/rooms");
	}
	
	@Test
	public void testRoomDetails()throws Exception
	{
		assertEquals(expected_roomName,room.getRoomName());
		assertEquals(expected_distance,room.getDistance());
		assertEquals(expected_noBedroom,room.getNoBathroom());
		assertEquals(expected_maxpeople,room.getMaxpeople());
		assertEquals(expected_cityId,room.getCityId());
		assertEquals(expected_roomUrl,room.getRoomUrl());
	
	}
}
