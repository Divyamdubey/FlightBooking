package com.services.FlightBooking.service.servicesImpl;

import com.services.FlightBooking.models.Admin;
import com.services.FlightBooking.models.Flight;
import com.services.FlightBooking.repository.AdminRepository;
import com.services.FlightBooking.repository.FlightRepository;
import com.services.FlightBooking.service.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AdminServiceImpl implements AdminService {

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    AdminRepository adminRepository;

    public  Flight addFlight(Flight flight){
        if (flight.getFlightNo().equals("")||flight.getName().equals("")||flight.getDepartureFrom().equals("")
                ||flight.getArrivalTo().equals("")||flight.getDepartureDate().equals("")
                ||flight.getArrivalDate().equals("")||flight.getCost()==0||flight.getTotalSeats()==0
                ||flight.getDiscountCode().equals("")||flight.getStatus().equals("")){
            return null;
        }
        return flightRepository.save(flight);}

    public Admin login(Admin admin) {
        Optional<Admin> admin2= Optional.ofNullable(adminRepository.findByAdminName(admin.getName()));
        if (!admin2.isPresent()) {
            return null;
        }
        Admin admin1= admin2.get();
        if (admin1.getPassword().equals(admin.getPassword())){
            return admin1;
        }
        return null;
    }

    public Flight changeStatus(String flightNo,String status){
        Optional<Flight> flightCheck = Optional.ofNullable(flightRepository.findByFlightNo(flightNo));
        if (!flightCheck.isPresent()){
            return null;
        }
        Flight flight = flightRepository.findByFlightNo(flightNo);
        flight.setStatus(status);
        flightRepository.save(flight);
        return  flight;
    }

    public Flight deleteFlight(String flightNo){
        Optional<Flight> flightCheck = Optional.ofNullable(flightRepository.findByFlightNo(flightNo));
        if (!flightCheck.isPresent()){
            return null;
        }
        Flight flight = flightRepository.findByFlightNo(flightNo);
        flightRepository.delete(flight);
        return  flight;
    }
    @Override
    public List<Flight> searchFlight() {
        return flightRepository.findAll();
    }
}

