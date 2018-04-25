package com.homestay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements INotificationService {
	private JavaMailSender javaMailSender;
	private String emailFrom="amshu.k1994@com";
	
	
	@Autowired 
	public NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	public void sendNotification(String email) throws MailException{
		//send email
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setFrom(emailFrom);
		mail.setSubject("Don not Reply @HomeStay.com");
		mail.setText("Booking Confirmation: \nThis is to confirm that your booking has been confirmed by HomeStay.");
        
		javaMailSender.send(mail);
	}
	

}
