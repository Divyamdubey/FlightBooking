package com.services.FlightBooking.controller;

import com.services.FlightBooking.models.*;
import com.services.FlightBooking.repository.BookingRepository;
import com.services.FlightBooking.repository.FlightRepository;
import com.services.FlightBooking.repository.PassengerRepository;
import com.services.FlightBooking.repository.UserRepository;
import com.services.FlightBooking.service.PnrGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PnrGenerator pnrGenerator;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @PostMapping("/api/v1.0/flight/search")
    @ResponseBody
    public List<Flight> userSearch(@RequestParam String flightDeparture,@RequestParam String flightArrival){
        List<Flight> flightList = new ArrayList<>();
        flightList = flightRepository.findByDeparture(flightDeparture,flightArrival);
        return flightList;
    }

    @PostMapping("/api/v1.0/flight/booking/{flightNo}")
    public Optional<Booking> userBookFlight(@PathVariable(name ="flightNo") String flightNo,@RequestBody Passenger passenger){
        System.out.println("FlightId"+flightNo);
        System.out.println("Passenger"+passenger.getBookingMail());
        Optional<Flight> checkFlight= Optional.ofNullable(flightRepository.findByFlightNo(flightNo));
        if (!checkFlight.isPresent())
            return Optional.of(new Booking());
        //Optional<Flight> flightDetails = flightRepository.findById(flightNo);
        String pnr = pnrGenerator.getPnr();
        passenger.setPnr(pnr);
        passengerRepository.save(passenger);
        Booking booking= new Booking();
        booking.setFlightNo(flightNo);
        booking.setPnr(pnr);
        booking.setUserEmail(passenger.getBookingMail());
        bookingRepository.save(booking);
        return Optional.of(booking);
    }

    @PostMapping("/api/v1.0/flight/airline/UserRegister")
    @ResponseBody
    public User userRegistration(@RequestBody User user){
        return userRepository.save(user);
    }


    @GetMapping("/api/v1.0/flight/ticket/{pnr}")
    @ResponseBody
    public Booking findByPnr( @PathVariable(value = "pnr") String pnr){
        return bookingRepository.findByPnr(pnr);
    }

    @DeleteMapping("/api/v1.0/flight/booking/cancel/{pnr}")
    @ResponseBody
    public Booking deleteByPnr( @PathVariable(value = "pnr") String pnr){
        Booking booking = bookingRepository.findByPnr(pnr);
        bookingRepository.delete(booking);
        return booking;
    }
}
