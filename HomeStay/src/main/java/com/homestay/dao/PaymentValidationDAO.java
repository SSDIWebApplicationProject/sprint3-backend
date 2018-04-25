package com.homestay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import com.homestay.connection.ConnectionUtil;
import com.homestay.model.Payment;
@Repository
@Configuration
@EnableAutoConfiguration
public class PaymentValidationDAO implements IPaymentValidationDAO{
	
	@Autowired
	ConnectionUtil Conn;
	public int validatePayment(Payment payment) {
		System.out.println("entered dao");
		System.out.println(payment.getCardNo());
		
		int message;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		Connection con;
		
		
		
	    try{  
		 con= (Connection) Conn.getConnection(); 
		 String cardNumber=payment.getCardNo();
		 
		 ps1=con.prepareStatement("select * from PaymentValidation where CardNumber='"+cardNumber+"'");
		 ResultSet rs=ps1.executeQuery();
		 
		 if (rs.next()) {
			 int cardId=rs.getInt("CardId");
			 System.out.println("cardId"+cardId);
			 if(rs.getInt("StudentId")==payment.getStudentId()) {
				 if(rs.getString("EmailId").equalsIgnoreCase(payment.getEmailId())) {
					 if(rs.getInt("BalanceMoney")>=payment.getTotalAmount()) {
						 PreparedStatement ps3=con.prepareStatement("select UserId from UserDetails where Email='"+payment.getUserEmail()+"'");
						 ResultSet rs1=ps3.executeQuery();
						 int userId=0;
						 while(rs1.next()) {
							  userId=rs1.getInt("UserId");
							  System.out.println("UserId"+ userId);
						 }
						 PreparedStatement ps4=con.prepareStatement("Update PaymentValidation set BalanceMoney=BalanceMoney-"+payment.getTotalAmount()+" where CardId="+cardId);
						 System.out.println(ps4);
			                     ps4.executeUpdate();
			             PreparedStatement ps5=con.prepareStatement("Update room set IsBooked=1 where room_id="+payment.getRoomId());
			             ps5.executeUpdate();
						 PreparedStatement ps2=con.prepareStatement("INSERT INTO `HomeStay`.`Booking` (`roomId`,`userid`,`cardId`,`arraivalDate`,`departureDate`,`totalCost`) VALUES("
					 +payment.getRoomId()+", "+userId+", "+cardId+", '"+payment.getArraivalDate()+"', '"+payment.getDepartureDate()+"', "+payment.getTotalAmount()+")");
                     ps2.executeUpdate();
						 
					 System.out.println("valid");
					 
					 message=1;	
					 }
					 else {
						 //balance insufficient
						 message=-1;
					 }
				
				 }
				 else {
					 //Emailid not valid
					 message=-2;
				 }
			 }
			 else {
				 //Studentid not valid
				 message=-3;
			 }
			
		 }
		 else { 
			 System.out.println("does not exist");
			 message=0;
		 }
		  }
	    catch(Exception e) {
	    	e.printStackTrace();
	    	message=0;
	    }
	    
		return message;
	
	}

	
}
