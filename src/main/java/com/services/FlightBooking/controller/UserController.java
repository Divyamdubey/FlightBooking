package com.services.FlightBooking.controller;

import com.services.FlightBooking.models.Booking;
import com.services.FlightBooking.models.Flight;
import com.services.FlightBooking.models.User;
import com.services.FlightBooking.repository.BookingRepo;
import com.services.FlightBooking.repository.FlightRepo;
import com.services.FlightBooking.repository.UserRepo;
import com.services.FlightBooking.service.PnrGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepo userRepo;

    @Autowired
    PnrGenerator pnrGenerator;

    @Autowired
    FlightRepo flightRepo;

    @Autowired
    BookingRepo bookingRepo;

    @PostMapping("/api/v1.0/flight/search")
    @ResponseBody
    public List<Flight> userSearch(@RequestParam String flightDeparture,@RequestParam String flightArrival){
        List<Flight> flightList = new ArrayList<>();
        flightList = flightRepo.findByDeparture(flightDeparture,flightArrival);
        return flightList;
    }

    @PostMapping("/api/v1.0/flight/booking/{flightid}")
    public Optional<Booking> userBookFlight(@PathVariable(name ="flightid") String flightId){
        Optional<Flight> flightDetails = flightRepo.findById(flightId);

        String pnr = pnrGenerator.getPnr();
        Booking booking= new Booking();
        booking.setFlightNo(flightId);
        booking.setPnr(pnr);
        booking.setUserEmail("user@gmail.con");
        bookingRepo.save(booking);
        return Optional.of(booking);
    }



    @PostMapping("/api/v1.0/flight/airline/UserRegister")
    @ResponseBody
    public User userRegistration(@RequestBody User user){
        return userRepo.save(user);
    }


    @GetMapping("/api/v1.0/flight/ticket/{pnr}")
    @ResponseBody
    public Booking findByPnr( @PathVariable(value = "pnr") String pnr){
        return bookingRepo.findByPnr(pnr);
    }

    @DeleteMapping("/api/v1.0/flight/booking/cancel/{pnr}")
    @ResponseBody
    public Booking deleteByPnr( @PathVariable(value = "pnr") String pnr){
        Booking booking = bookingRepo.findByPnr(pnr);
        bookingRepo.delete(booking);
        return booking;
    }
}
