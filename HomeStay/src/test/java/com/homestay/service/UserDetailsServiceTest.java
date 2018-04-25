package com.homestay.service;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.homestay.dao.IUserDAO;
import com.homestay.model.User;

public class UserDetailsServiceTest {

	@Autowired
	IUserDetailsService userservice;
	
	@MockBean
	private IUserDAO userdao;
	
	
	@Test(expected=NullPointerException.class)
	public void registerUserTest() {
		ArrayList<User> user= new ArrayList<>();
		User user1=new User();
		user1.setFirstName("Anjani");
		user1.setLastName("Vemula");
		user1.setPhoneNumber(1234);
		user1.setEmailId("avemual@uncc.edu");
		user.add(user1);
		Mockito.when(userdao.registerUser(user1)).thenReturn("Success");
		assertThat(userservice.registerUser(user1)).isEqualTo("Success");
		
	}
	
	
	

}
