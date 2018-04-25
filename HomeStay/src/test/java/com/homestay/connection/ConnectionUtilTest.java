package com.homestay.connection;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class ConnectionUtilTest {

	@Test
	public void getConnectioNTest() {
		Connection conn=null;
			try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestHomeStay","root","root");
			}
			catch(Exception e){
				e.printStackTrace();
			}  
			   assertEquals(conn != null, true);
	}
}
