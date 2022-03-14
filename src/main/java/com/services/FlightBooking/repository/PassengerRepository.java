package com.services.FlightBooking.repository;

import com.services.FlightBooking.models.Booking;
import com.services.FlightBooking.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PassengerRepository extends JpaRepository<Passenger,Integer> {

    @Query(value = "select a from Passenger a where a.pnr = :pnr")
    Passenger findByPnr(@Param(value = "pnr") String pnr);
}
