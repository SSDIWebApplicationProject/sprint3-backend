package com.homestay.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaymentModelTest {

	   
	   
	   private Payment payment;
	   
	@Before
	public void setPaymentDetails()
	{
		payment=new Payment();
		payment.setCardNo("123456789");
		payment.setEmailId("pshirodk@uncc.edu");
		payment.setStudentId(801021058);
		payment.setTotalAmount(500.00);
		payment.setRoomId(1);
		payment.setArraivalDate("1234");
		payment.setDepartureDate("1234");
	}
	@Test
	public void testPaymentDetails () throws Exception {
		assertEquals(payment.getCardNo(),"123456789");
		assertEquals(payment.getEmailId(),"pshirodk@uncc.edu");
		assertEquals(payment.getStudentId(),801021058);
		assertEquals(payment.getTotalAmount(),500.00,0.001);
		
		assertEquals(payment.getRoomId(),1);
		assertEquals(payment.getArraivalDate(), "1234");
		assertEquals(payment.getDepartureDate(), "1234");
	}
}
