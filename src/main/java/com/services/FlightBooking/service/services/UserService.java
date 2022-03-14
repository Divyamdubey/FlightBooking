package com.services.FlightBooking.service.services;

import com.services.FlightBooking.models.Booking;
import com.services.FlightBooking.models.Flight;
import com.services.FlightBooking.models.Passenger;
import com.services.FlightBooking.models.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User login(User user);
    public List<Flight> search(String flightDeparture, String flightArrival);
    public Optional<Booking> userBookFlight(String flightNo, Passenger passenger);
    public User userRegistration(User user);
    public Booking findByPnr(@PathVariable(value = "pnr") String pnr);
    public List<Booking> findByMail(String emailId);
    public Booking deleteByPnr(String pnr);
}
