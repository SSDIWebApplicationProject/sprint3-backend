package com.homestay.model;

public class Payment {
   private String emailId;
   private long studentId;
   private String cardNo;
   private double totalAmount;
   private String arraivalDate;
   private String departureDate;
   private int roomId;
   private String userEmail;

   public String getArraivalDate() {
	return arraivalDate;
}
public void setArraivalDate(String arraivalDate) {
	this.arraivalDate = arraivalDate;
}
public String getDepartureDate() {
	return departureDate;
}
public void setDepartureDate(String departureDate) {
	this.departureDate = departureDate;
}
public int getRoomId() {
	return roomId;
}
public void setRoomId(int roomId) {
	this.roomId = roomId;
}
public String getUserEmail() {
	return userEmail;
}
public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public long getStudentId() {
	return studentId;
}
public void setStudentId(long studentId) {
	this.studentId = studentId;
}
public String getCardNo() {
	return cardNo;
}
public void setCardNo(String cardNo) {
	this.cardNo = cardNo;
}
public double getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(double totalAmount) {
	this.totalAmount = totalAmount;
}
   
  
}


