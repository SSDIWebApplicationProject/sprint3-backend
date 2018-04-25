package com.homestay.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.homestay.connection.ConnectionUtil;
import com.homestay.connection.IConnection;
import com.homestay.model.Room;

public class SearchDaoTest {

	@Autowired
	SearchDAO searchDao;
	@MockBean
	ConnectionUtil Conn1;
	
	@Test
	public void  getRoomDetailsTest() {
		PreparedStatement ps=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection Conn2 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testhomestay","root","root");	
			
		ps=Conn2.prepareStatement("delete from room");
		ps.executeUpdate();
		ArrayList<Room> rooms= new ArrayList<>();
		Mockito.when(Conn1.getConnection()).thenReturn(Conn2);
		
		System.out.println(Conn1);
		rooms=searchDao.getRoomDetails();
		
		assertEquals(0,rooms.size());
		
		}
		catch(Exception e){
			e.printStackTrace();
		}  
	
	   
		
	}
	
	@Test
	public void  getRoomDetailsTest2() {
		PreparedStatement ps=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection Conn2 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testhomestay","root","root");	
			
		ps=Conn2.prepareStatement("delete from room");
		ps.executeUpdate();
		ps=Conn2.prepareStatement("insert into room  values (4,'room1','distance',1,2,5,1,'url',100)");
		ps.executeUpdate();
		ArrayList<Room> rooms= new ArrayList<>();
		Mockito.when(Conn1.getConnection()).thenReturn(Conn2);
		
		System.out.println(Conn1);
		rooms=searchDao.getRoomDetails();
		
		assertEquals(1,rooms.size());
		
		}
		catch(Exception e){
			e.printStackTrace();
		}  
	
	   
		
	}
	
	

}
