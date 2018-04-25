package com.homestay.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.homestay.dao.IHomeDAO;

@Service
public class CityDetailsService implements ICityDetails {
    @Autowired
	IHomeDAO home;
    
	
	@Override
	public ArrayList<String> GetCity() {
		ArrayList<String> cityDetails=new ArrayList<>();
		cityDetails = home.getCity();
		return cityDetails;
		}

}
