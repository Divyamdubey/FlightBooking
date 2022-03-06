package com.services.FlightBooking.service.services;

import com.services.FlightBooking.models.Admin;
import com.services.FlightBooking.models.Flight;
import org.springframework.web.bind.annotation.RequestBody;

public interface AdminService {

    public Admin login(Admin admin);
    public Flight addFlight(Flight flight);
    public String changeStatus(String flightNo,String status);
}
