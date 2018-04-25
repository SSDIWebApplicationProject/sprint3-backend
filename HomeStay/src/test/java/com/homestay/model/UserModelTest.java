package com.homestay.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserModelTest {
	private String expected_fName="Anjani";
	private String expected_lName="Vemula";
	private String expected_email="avemula@uncc.edu";
	private int expected_phone=456788888;
	
	private User user;
	
	@Before
	public void setUserDetails()
	{
		user=new User();
		user.setFirstName(expected_fName);;
		user.setLastName(expected_lName);
		user.setEmailId(expected_email);
		user.setPhoneNumber(expected_phone);
	}
	
	

	@Test
	public void testSearchDetails () throws Exception
	{
		assertEquals(expected_fName,user.getFirstName());
		assertEquals(expected_lName,user.getLastName());
		assertEquals(expected_email,user.getEmailId());
		assertEquals(expected_phone,user.getPhoneNumber());
	}


}
