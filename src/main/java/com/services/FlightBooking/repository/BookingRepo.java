package com.services.FlightBooking.repository;

import com.services.FlightBooking.models.Booking;
import com.services.FlightBooking.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRepo  extends JpaRepository<Booking,Integer> {

    @Query(value = "select a from Booking a where a.pnr = :pnr")
    Booking findByPnr(@Param(value = "pnr") String pnr);


}


