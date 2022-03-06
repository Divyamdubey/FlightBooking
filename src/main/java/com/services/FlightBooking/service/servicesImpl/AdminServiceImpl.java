package com.services.FlightBooking.service.servicesImpl;

import com.services.FlightBooking.models.Admin;
import com.services.FlightBooking.models.Flight;
import com.services.FlightBooking.repository.AdminRepository;
import com.services.FlightBooking.repository.FlightRepository;
import com.services.FlightBooking.service.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AdminServiceImpl implements AdminService {

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    AdminRepository adminRepository;

    public  Flight addFlight(Flight flight){return flightRepository.save(flight);}

    public Admin login(Admin admin) {
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

    public String changeStatus(String flightNo,String status){
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

