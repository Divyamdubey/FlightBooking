package com.services.FlightBooking.repository;

import com.services.FlightBooking.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookingRepository extends JpaRepository<Booking,Integer> {

    @Query(value = "select a from Booking a where a.pnr = :pnr")
    Booking findByPnr(@Param(value = "pnr") String pnr);


}


