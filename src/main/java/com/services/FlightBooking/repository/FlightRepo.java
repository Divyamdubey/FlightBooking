package com.services.FlightBooking.repository;

import com.services.FlightBooking.models.Admin;
import com.services.FlightBooking.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepo extends JpaRepository<Flight,String> {

    @Query(value = "select a from Flight a where a.departureFrom = :departureFrom and a.arrivalTo = :arrivalTo")
    List<Flight> findByDeparture(@Param(value = "departureFrom") String departureFrom, @Param(value = "arrivalTo") String arrivalTo);

}
