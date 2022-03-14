package com.services.FlightBooking.service.services;

import com.services.FlightBooking.models.Admin;
import com.services.FlightBooking.models.Flight;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AdminService {

    public Admin login(Admin admin);
    public Flight addFlight(Flight flight);
    public Flight changeStatus(String flightNo,String status);
    public List<Flight> searchFlight();
}
