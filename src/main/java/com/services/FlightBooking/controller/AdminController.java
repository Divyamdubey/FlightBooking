package com.services.FlightBooking.controller;

import com.services.FlightBooking.models.Admin;
import com.services.FlightBooking.models.Flight;
import com.services.FlightBooking.repository.AdminRepository;
import com.services.FlightBooking.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AdminController {

    @Autowired
    AdminRepository adminRepository;
    @Autowired
    FlightRepository flightRepository;

    @PostMapping("/flight/airline/inventory/add")
    public Flight addFlight(@RequestBody Flight flight){return  flightRepository.save(flight);}

    @PostMapping("/flight/admin/login")
    public Admin login(@RequestBody Admin admin) {
        Optional<Admin> admin2= Optional.ofNullable(adminRepository.findByAdminName(admin.getName()));
        if (!admin2.isPresent()) {
            return new Admin();
        }
        Admin admin1= admin2.get();
        if (admin1.getPassword().equals(admin.getPassword())){
            return admin1;
        }
        return new Admin();
    }

    @PutMapping("/flight/admin/status")
    public String changeStatus(@RequestParam(value ="flightNo") String flightNo,@RequestParam(value ="status") String status){
        Optional<Flight> flightCheck = Optional.ofNullable(flightRepository.findByFlightNo(flightNo));
        if (!flightCheck.isPresent()){
            return "Flight not present";
        }
        Flight flight = flightRepository.findByFlightNo(flightNo);
        flight.setStatus(status);
        flightRepository.save(flight);
        return  "status changed";

    }

}
