package com.homestay.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;


@Repository
@Configuration
@EnableAutoConfiguration
public class ConnectionUtil implements IConnection {
	  static String Driver="com.mysql.jdbc.Driver";  
	  static String connection_url="jdbc:mysql://localhost:3306/HomeStay";  
	  static String userName="root";  
	  static String password="root";
	public Connection getConnection() {
		Connection conn=null;
		try{  
			Class.forName(Driver);
			conn = (Connection) DriverManager.getConnection(connection_url,userName,password);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}  
		return conn;
	}

}
