package com.homestay.service;



import org.junit.Test;

import org.springframework.mail.javamail.JavaMailSender;

public class NotificationServiceTest {
	private JavaMailSender javaMailSender;
	
	

	@Test(expected=NullPointerException.class)
	public void sendNotificationTest() {
		NotificationService service=new NotificationService(javaMailSender);
		service.sendNotification("avemula@uncc.edu");
	}	

}
