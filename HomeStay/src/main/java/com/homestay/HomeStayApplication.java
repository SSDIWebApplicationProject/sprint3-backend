package com.homestay;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.homestay.service.CityDetailsService;

@SpringBootApplication
public class HomeStayApplication {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext=SpringApplication.run(HomeStayApplication.class, args);
		CityDetailsService City= applicationContext.getBean(CityDetailsService.class);
		
		
	}
}
