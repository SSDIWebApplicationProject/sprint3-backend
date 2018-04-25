package com.homestay.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.homestay.dao.IPaymentValidationDAO;
import com.homestay.model.Payment;

public class PaymentServiceTest {

	@Autowired
	PaymentValidationService paymentservice;
	
	@MockBean
	private NotificationService notificationservice;
	@MockBean
	private IPaymentValidationDAO pamentDao;
	
	
	@Test(expected=NullPointerException.class)
	public void PaymentNotificationtest() {
		Payment payment=new Payment();
		payment.setCardNo("123456789");
		payment.setEmailId("pshirodk@uncc.edu");
		payment.setStudentId(801021058);
		payment.setTotalAmount(500.00);
		payment.setRoomId(1);
		payment.setArraivalDate("1234");
		payment.setDepartureDate("1234");
		
		
		Mockito.when(pamentDao.validatePayment(payment)).thenReturn(1);
		
		assertEquals(paymentservice.validatePayment(payment),1);
	}


}
