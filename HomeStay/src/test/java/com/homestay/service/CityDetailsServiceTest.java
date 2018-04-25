package com.homestay.service;



import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;
import com.homestay.dao.IHomeDAO;

@Service
public class CityDetailsServiceTest {
	@Autowired ICityDetails cityDetailsService; 
	@MockBean private IHomeDAO homeDao;	


	@Test(expected=NullPointerException.class)
	public void GetCity_Test() {
		
		ArrayList<String> cities= new ArrayList<>();
		cities.add("San Jose");
		cities.add("Charlotte");
		Mockito.when(homeDao.getCity()).thenReturn(cities);
		ArrayList<String> testCities= new ArrayList<>();
		testCities=cityDetailsService.GetCity();
		assertEquals(2,testCities.size());
		assertEquals("San Jose",testCities.get(0));
		assertEquals("Charlotte",testCities.get(1));
		}
	
	@Test(expected=NullPointerException.class)
	public void GetCity_Test1() {
		
		ArrayList<String> cities= new ArrayList<>();
		Mockito.when(homeDao.getCity()).thenReturn(cities);
		ArrayList<String> testCities= new ArrayList<>();
		testCities=cityDetailsService.GetCity();
		assertEquals(0,testCities.size());
		
		}
	
}
