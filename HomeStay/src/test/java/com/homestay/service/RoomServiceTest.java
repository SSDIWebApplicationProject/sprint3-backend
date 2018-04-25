package com.homestay.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.homestay.dao.ISearchDAO;
import com.homestay.model.Room;

public class RoomServiceTest {
	
	@Autowired
	RoomService roomservice;
	
	@MockBean
	private ISearchDAO search;
	
	
	@Test(expected=NullPointerException.class)
	public void getRoomDetailsTestInsertData() {
		ArrayList<Room> rooms= new ArrayList<>();
		Room R=new Room();
		R.setCityId(1);
		R.setDistance("5");
		R.setId(1);
		R.setNoBathroom(2);
		R.setNoBedroom(2);
		R.setRoomName("Room1");
		R.setRoomUrl("abc");
		rooms.add(R);
		Mockito.when(search.getRoomDetails()).thenReturn(rooms);
		assertThat(roomservice.getRoomDetails()).isEqualTo(rooms);
		ArrayList<Room> testedRooms = search.getRoomDetails();
		assertEquals(1, testedRooms.size());
		assertEquals(1,testedRooms.get(0));
	}
	
	@Test(expected=NullPointerException.class)
	public void getRoomDetailsTestNoDataInserted() {

		ArrayList<Room> rooms= new ArrayList<>();
		Mockito.when(search.getRoomDetails()).thenReturn(rooms);
		ArrayList<Room> testedRooms = search.getRoomDetails();
		assertEquals(0, testedRooms.size());
	}

}
