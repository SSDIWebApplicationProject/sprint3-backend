
package com.homestay.dao;



import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.homestay.connection.ConnectionUtil;




public class HomeDaoTest {
	
	@Autowired
	HomeDAO homeDao;
	@MockBean
	ConnectionUtil Conn1;
	
	
    @Test
	public void getCityDetailsTest() {
		PreparedStatement ps=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection Conn2 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testhomestay","root","root");	
			
		ps=Conn2.prepareStatement("delete from city");
		ps.executeUpdate();
		ArrayList<String> cities= new ArrayList<>();
		Mockito.when(Conn1.getConnection()).thenReturn(Conn2);
		
		System.out.println(Conn1);
		cities=homeDao.getCity();
		System.out.println(cities);
		assertEquals(0,cities.size());
		
		}
		catch(Exception e){
			e.printStackTrace();
		}  
	}
    
    @Test
	public void getCityDetailsTest2() {
		PreparedStatement ps=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection Conn2 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testhomestay","root","root");	
			
		ps=Conn2.prepareStatement("delete from city");
		ps.executeUpdate();
		ps=Conn2.prepareStatement("insert into city (CityId, CityName, CityCode) values (?,?,?)");
		ps.setString(1, "1");
		ps.setString(2, "San Jose");
		ps.setString(3, "SJC");
		ps.executeUpdate();
		ArrayList<String> cities= new ArrayList<>();
		Mockito.when(Conn1.getConnection()).thenReturn(Conn2);
		
		System.out.println(Conn1);
		cities=homeDao.getCity();
		System.out.println(cities);
		assertEquals(1,cities.size());
		
		}
		catch(Exception e){
			e.printStackTrace();
		}  
	}
    
	
}
