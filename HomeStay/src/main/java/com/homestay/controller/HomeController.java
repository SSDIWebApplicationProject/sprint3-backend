package com.homestay.controller;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.homestay.model.Payment;
import com.homestay.model.Room;
import com.homestay.model.Search;
import com.homestay.model.User;
import com.homestay.service.ICityDetails;
import com.homestay.service.IPaymentvalidationService;
import com.homestay.service.IRoomService;
import com.homestay.service.IUserDetailsService;


@RestController
public class HomeController {
	// whenever root path is called the below method will be executed
	
	@Autowired
	IRoomService room;
	@Autowired
	ICityDetails city;
	@Autowired
	IUserDetailsService userService;
	@Autowired
	IPaymentvalidationService paymentService;
	
		
	@PostMapping(value= "/search")
	public ArrayList<Room> getRooms(@RequestBody Search search) {
		return room.getRoom(search);
	}
	
	@PostMapping(value= "/user")
	public String registerUser(@RequestBody User user) {
		return userService.registerUser(user);
	}
	
	@PostMapping(value= "/payment")
	public int validatePayment(@RequestBody Payment payment) {
		
		return paymentService.validatePayment(payment);
	}
	
	
	@GetMapping(value="/city")
	public ArrayList<String> getCities() {
		return city.GetCity();
	}
	
	@PostMapping(value="/rooms")
	public ArrayList<Room> getRooms() {
		return room.getRoomDetails();
	}

}
