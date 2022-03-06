package com.services.FlightBooking.controller;

import com.services.FlightBooking.models.Admin;
import com.services.FlightBooking.models.Flight;
import com.services.FlightBooking.service.servicesImpl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    AdminServiceImpl adminService;

    @PostMapping("/flight/airline/inventory/add")
    public Flight addFlight(@RequestBody Flight flight){return adminService.addFlight(flight);}

    @PostMapping("/flight/admin/login")
    public Admin login(@RequestBody Admin admin) {
        return adminService.login(admin);
    }

    @PutMapping("/flight/admin/status")
    public String changeStatus(@RequestParam(value ="flightNo") String flightNo,@RequestParam(value ="status") String status){
      return adminService.changeStatus(flightNo,status);
    }

}
