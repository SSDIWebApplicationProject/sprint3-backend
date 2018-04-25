package com.homestay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import com.homestay.connection.ConnectionUtil;
import com.homestay.model.User;


@Repository
@Configuration
@EnableAutoConfiguration
public class UserDAO implements IUserDAO{
	
	@Autowired
	ConnectionUtil Conn;
	
	public String registerUser(User user) {
		String message;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		Connection con;
		
		
		
	    try{  
		 con= (Connection) Conn.getConnection(); 
		 String userEmail=user.getEmailId();
		 
		 ps1=con.prepareStatement("select UserId from UserDetails where Email='"+userEmail+"'");
		 ResultSet rs=ps1.executeQuery();
		 
		 if (rs.next()) {
			int id=rs.getInt("UserId");
			ps=con.prepareStatement("update UserDetails set FirstName='"+user.getFirstName()+"', LastName='"+user.getLastName()+"', PhoneNumber="+user.getPhoneNumber()+" where Email='"+userEmail+"'"); 
			
			ps.executeUpdate(); 
			message="Updated User Sucessfully";	
		 }
		 else { 
		ps=con.prepareStatement("insert into UserDetails (FirstName, LastName, Email, PhoneNumber) values ('"+user.getFirstName()+"', '"+user.getLastName()+"', '"+user.getEmailId()+"', "+user.getPhoneNumber()+")"); 
	   
		ps.executeUpdate(); 
		message="Added User Sucessfully";
		 }
		  }
	    catch(Exception e) {
	    	e.printStackTrace();
	    	message="Fail";
	    }
	    
		return message;
	
	}
}
