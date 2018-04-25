package com.homestay.dao;


import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.homestay.connection.ConnectionUtil;
import com.homestay.model.Payment;
public class PaymentDaoTest {
	@MockBean
	ConnectionUtil Conn1;
	@Autowired 
	PaymentValidationDAO paymentValidate;
	Payment paymeny;
	
	
	@Test
	public void test() 
	{

		Payment payment=new Payment();
		payment.setCardNo("123456");
		payment.setEmailId("avemula@uncc.edu");
		payment.setStudentId(801027617);
		payment.setTotalAmount(200);
		

		PaymentValidationDAO paymentValidate= new PaymentValidationDAO();
		PreparedStatement ps=null;
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection Conn2 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testhomestay","root","root");	
		
		ps=Conn2.prepareStatement("delete from payment");
		ps.executeUpdate();
		Mockito.when(Conn1.getConnection()).thenReturn(Conn2);
		assertEquals(paymentValidate.validatePayment(payment),"success");
		ps=Conn2.prepareStatement("insert into payment (cardid,emailid,studentid,studentname,cardnumber,balancemoney) values (?,?,?,?,?,?)");
		
		
		assertEquals(paymentValidate.validatePayment(payment),1);
		

		Payment payment1=new Payment();
		payment.setCardNo("123456789");
		payment.setEmailId("pshirodk@uncc.edu");
		payment.setStudentId(801021058);
		payment.setTotalAmount(1000);
		assertEquals(paymentValidate.validatePayment(payment1),-1);


		Payment payment2=new Payment();
		payment.setCardNo("123456789");
		payment.setEmailId("pshirodk@gmail.com");
		payment.setStudentId(801021058);
		payment.setTotalAmount(200);
		assertEquals(paymentValidate.validatePayment(payment2),-2);
		


		Payment payment3=new Payment();
		payment.setCardNo("123456789");
		payment.setEmailId("pshirodk@uncc.edu");
		payment.setStudentId(801021050);
		payment.setTotalAmount(200);
		assertEquals(paymentValidate.validatePayment(payment3),-3);
		
		

		Payment payment4=new Payment();
		payment.setCardNo("123456777");
		payment.setEmailId("pshirodk@gmail.com");
		payment.setStudentId(801021050);
		payment.setTotalAmount(1000);
		assertEquals(paymentValidate.validatePayment(payment4),0);
		
		
		}
		catch(Exception e){
			e.printStackTrace();
		}  
		
	}

}

