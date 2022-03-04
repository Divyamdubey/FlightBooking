package com.services.FlightBooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = { "com.services.FlightBooking" })
@EnableTransactionManagement
public class FlightBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightBookingApplication.class, args);
	}

}
