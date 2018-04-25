package com.homestay.model;

public class Room {

	private int id;
	private String roomName;
	private String distance;
	private int noBedroom;
	private int noBathroom;
	private int maxpeople;
	private int cityId;
	private String roomUrl;
	private int CostPerDay;
	
	
	public int getCostPerDay() {
		return CostPerDay;
	}
	public void setCostPerDay(int costPerDay) {
		CostPerDay = costPerDay;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getRoomUrl() {
		return roomUrl;
	}
	public void setRoomUrl(String roomUrl) {
		this.roomUrl = roomUrl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public int getNoBedroom() {
		return noBedroom;
	}
	public void setNoBedroom(int noBedroom) {
		this.noBedroom = noBedroom;
	}
	public int getNoBathroom() {
		return noBathroom;
	}
	public void setNoBathroom(int noBathroom) {
		this.noBathroom = noBathroom;
	}
	public int getMaxpeople() {
		return maxpeople;
	}
	public void setMaxpeople(int maxpeople) {
		this.maxpeople = maxpeople;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	

}
