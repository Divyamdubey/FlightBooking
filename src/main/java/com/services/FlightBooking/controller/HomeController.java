package com.services.FlightBooking.controller;

import com.services.FlightBooking.models.User;
import com.services.FlightBooking.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    UserRepo userRepo;

    @RequestMapping("/")
    public String homePage(){
        return "home.html";
    }

    @RequestMapping("/AdminLogin")
    public String adminLoginPage(){
        return "adminLogin.html";
    }

    @RequestMapping("/Registration")
    public String userRegistrationPage(){ return "userRegistration.html";}

    @RequestMapping("/UserLogin")
    public String userLoginPage(){

        return "userLogin.html";
    }
}
