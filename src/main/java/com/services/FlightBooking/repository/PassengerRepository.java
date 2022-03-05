package com.services.FlightBooking.repository;

import com.services.FlightBooking.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Integer> {
}
