package com.homestay.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class SearchModelTest {

	private int expected_noofGuests=3;
	private String expected_city="San Jose";
	private Search search;
	
	@Before
	public void setSearchDetails()
	{
		search=new Search();
		search.setNoofGuests(3);
		search.setCity("San Jose");
	}
	
	@Test
	public void testSearchDetails () throws Exception
	{
		assertEquals(expected_noofGuests,search.getNoofGuests());
		assertEquals(expected_city,search.getCity());
	}

}


