package com.services.FlightBooking.controller;

import com.services.FlightBooking.models.*;
import com.services.FlightBooking.service.servicesImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/flight/user/login")
    public User login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping("/flight/search")
    public List<Flight> search(@RequestParam String flightDeparture,@RequestParam String flightArrival){
       return userService.search(flightDeparture,flightArrival);
    }

    @CrossOrigin(value = "http://localhost:4200")
    @PostMapping("/flight/booking/{flightNo}")
    public Optional<Booking> userBookFlight(@PathVariable(name ="flightNo") String flightNo,@RequestBody Passenger passenger){
      return userService.userBookFlight(flightNo,passenger);
    }

    @PostMapping("/flight/airline/UserRegister")
    public User userRegistration(@RequestBody User user){
        return userService.userRegistration(user);
    }

    @GetMapping("/flight/ticket/{pnr}")
    public Booking findByPnr(@PathVariable(value = "pnr") String pnr){
        return userService.findByPnr(pnr);
    }

    @GetMapping("/flight/booking/history/{emailId}")
    public List<Booking> findByMail(@PathVariable(value = "emailId") String emailId){
        return  userService.findByMail(emailId);
    }
    @GetMapping("/flight/booking/passenger/{pnr}")
    public Passenger findPassenger(@PathVariable(value = "pnr") String pnr){
        return  userService.findPassenger(pnr);
    }
    @DeleteMapping("/flight/booking/cancel/{pnr}")
    public Booking deleteByPnr( @PathVariable(value = "pnr") String pnr){
       return userService.deleteByPnr(pnr);
    }
}
