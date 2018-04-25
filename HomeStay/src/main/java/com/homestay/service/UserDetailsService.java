package com.homestay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homestay.dao.IUserDAO;
import com.homestay.model.User;

@Service
public class UserDetailsService implements IUserDetailsService{
	@Autowired
	IUserDAO userDao;
	
	public String registerUser(User user) {
		return userDao.registerUser(user);
	}

}
