package com.homestay.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.homestay.connection.ConnectionUtil;
import com.homestay.model.User;


public class UserDaoTest {
	
	@Autowired
	UserDAO userDao;
	@MockBean
	ConnectionUtil Conn1;

	@Test
	public void test() {
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection Conn2 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testhomestay","root","root");	
			
		
		User user=new User();
		user.setFirstName("Anjani");
		user.setLastName("Vemula");
		user.setEmailId("123@mail.com");
		user.setPhoneNumber(12345);
		Mockito.when(Conn1.getConnection()).thenReturn(Conn2);
		
		System.out.println(Conn1);
		String message=userDao.registerUser(user);
		
		assertEquals("Added User Sucessfully",message);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}  
	}
	@Test
	public void test2() {
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection Conn2 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testhomestay","root","root");	
			
		
		User user=new User();
		user.setFirstName("Anjani");
		user.setLastName("Vemula");
		user.setEmailId("123@mail.com");
		user.setPhoneNumber(12345);
		User user2=new User();
		user2.setFirstName("Anjani");
		user2.setLastName("Sri");
		user2.setEmailId("123@mail.com");
		user2.setPhoneNumber(12345);
		Mockito.when(Conn1.getConnection()).thenReturn(Conn2);
		
		System.out.println(Conn1);
		String message=userDao.registerUser(user);
		
		assertEquals("Added User Sucessfully",message);
		String message2=userDao.registerUser(user2);
		
		assertEquals("Updated User Sucessfully",message2);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}  
	}
	
	

}
