package com.homestay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homestay.dao.IPaymentValidationDAO;
import com.homestay.model.Payment;


@Service
public class PaymentValidationService implements IPaymentvalidationService {
	
	
	@Autowired
	IPaymentValidationDAO pamentDao;
	@Autowired
	INotificationService notificationService;
	public int validatePayment(Payment payment) {
		System.out.println("entered service");
		int result;
		result=pamentDao.validatePayment(payment);
		if(result==1) {
			notificationService.sendNotification(payment.getEmailId());
		}
		
		return result;
	}
}
