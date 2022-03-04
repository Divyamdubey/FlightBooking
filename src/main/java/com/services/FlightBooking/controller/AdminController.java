package com.services.FlightBooking.controller;

import com.services.FlightBooking.models.Admin;
import com.services.FlightBooking.models.Flight;
import com.services.FlightBooking.models.User;
import com.services.FlightBooking.repository.AdminRepo;
import com.services.FlightBooking.repository.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminRepo adminRepo;
    @Autowired
    FlightRepo flightRepo;

    @PostMapping("/flight/airline/inventory/add")
    public Flight addFlight(@RequestBody Flight flight){

      return  flightRepo.save(flight);
    }

    @PostMapping("/flight/admin/login")
    public Admin adminLogin(@RequestBody Admin admin) {
        List<Admin> adminCheck = adminRepo.findAll();
        Admin admin1 = adminCheck.get(0);
        if(!admin1.getAdminName().equals(admin.getAdminName())){
            return new Admin();
        }
        if (admin1.getAdminPassword().equals(admin.getAdminPassword())){
            return admin1;
        }
        return new Admin();
    }
}
