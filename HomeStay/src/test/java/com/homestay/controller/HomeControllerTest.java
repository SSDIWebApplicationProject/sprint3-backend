package com.homestay.controller;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.homestay.model.Payment;
import com.homestay.model.Room;
import com.homestay.model.User;
import com.homestay.service.ICityDetails;
import com.homestay.service.IPaymentvalidationService;
import com.homestay.service.IRoomService;
import com.homestay.service.IUserDetailsService;
@RunWith(SpringRunner.class)
@WebMvcTest(value= HomeController.class ,secure=false)

public class HomeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IRoomService iRoomService;
	@MockBean
	private ICityDetails iCityDetails;
	@MockBean
	private IUserDetailsService iUserDetails;

	@Test
	public void GetCity_Test() throws Exception {
		ArrayList<String> cities= new ArrayList<>();
		cities.add("Charlotte");
		cities.add("San Jose");
		String inputInJson=this.mapToJson(cities);
		String URL="/city";
    	Mockito.when(iCityDetails.GetCity()).thenReturn(cities);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get(URL).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		/*Creating a Request builder to be able to execute a get request to uri with accept header as “application/json”*/
	    MvcResult result=mockMvc.perform(requestBuilder).andReturn();
	    /*mockMvc is used to perform the request and return the response back.*/
		MockHttpServletResponse response=result.getResponse();
		/*Mock implementation of the javax.servlet.http.HttpServletResponse interface*/
		String outputInJson=result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(),response.getStatus());
	
	}
	
	private String mapToJson(ArrayList<String> cities) throws JsonProcessingException{
		ObjectMapper objectMapper= new ObjectMapper();
		return objectMapper.writeValueAsString(cities);
	}

	private String mapToJson(Payment payment) throws JsonProcessingException{
		ObjectMapper objectMapper= new ObjectMapper();
		return objectMapper.writeValueAsString(payment);
	}


	@Test
	public void getRoomDetailsTest() throws Exception{
		ArrayList<Room> r=new ArrayList<Room>();
		Room R=new Room();
		R.setCityId(1);
		R.setDistance("5");
		R.setId(1);
		R.setNoBathroom(2);
		R.setNoBedroom(2);
		R.setRoomName("Romm1");
		R.setRoomUrl("abc");
		r.add(R);
		
		String inputInJson=this.mapToJson(R);
		String URL="/rooms";
		Mockito.when(iRoomService.getRoomDetails()).thenReturn(r);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.post(URL).accept(MediaType.APPLICATION_JSON)
				.content(inputInJson).contentType(MediaType.APPLICATION_JSON);
	
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response=result.getResponse();
		String outputInJson=result.getResponse().getContentAsString();
		//assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(),response.getStatus());
		System.out.println(response.getStatus());

	}
	
	private String mapToJson(Room r) throws JsonProcessingException{
			ObjectMapper objectMapper= new ObjectMapper();
			return objectMapper.writeValueAsString(r);
	}
	
	
	
	@MockBean
	private IPaymentvalidationService paymentService;
	
	@Test 
	public void getPaymentValidationTest() throws Exception
	{
		Payment payment=new Payment();
		payment.setCardNo("123456789");
		payment.setEmailId("pshirodk@uncc.edu");
		payment.setStudentId(801021058);
		payment.setTotalAmount(500.00);
		
		
		String URL="/payment";
		String inputInJson=this.mapToJson(payment);
		Mockito.when(paymentService.validatePayment(payment)).thenReturn(1);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.post(URL).accept(MediaType.APPLICATION_JSON).content(inputInJson).
				contentType(MediaType.APPLICATION_JSON);
	
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response=result.getResponse();
		
		String outputInJson=result.getResponse().getContentAsString();
		System.out.println(result);
		System.out.println(result.getResponse().getContentType());
		//assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(),response.getStatus());
	}



}




