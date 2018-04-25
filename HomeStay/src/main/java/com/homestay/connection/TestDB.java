package com.homestay.connection;

import java.sql.Connection;
import java.sql.DriverManager;




public class TestDB implements IConnection {
	  static String Driver="com.mysql.jdbc.Driver";  
	  static String connection_url="jdbc:mysql://localhost:3306/HomeStayTest";  
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
