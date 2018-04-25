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
import com.homestay.connection.IConnection;



@Repository
@Configuration
@EnableAutoConfiguration
public class HomeDAO implements IHomeDAO  {
	@Autowired
	IConnection Conn;
	
	 
	 public ArrayList<String> getCity() {
		 ArrayList<String> cities=new ArrayList<>();
		 PreparedStatement ps=null;
		 Connection con;
	    try{  
		 con= (Connection) Conn.getConnection();  
	
		ps=con.prepareStatement("select CityName from City"); 		             
		ResultSet rs=ps.executeQuery(); 
		while (rs.next()) {
			String city = rs.getString("CityName");
			cities.add(city);
		    }
		  }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
		return cities;
	}
	 
	 public void getData() {
		 
	 }
}
