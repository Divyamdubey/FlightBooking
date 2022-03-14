package com.services.FlightBooking.repository;

import com.services.FlightBooking.models.Flight;
import com.services.FlightBooking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "select a from User a where a.email = :email")
    User findByEmail(@Param(value ="email") String email);

    @Query(value = "select a from User a where a.phone = :phone")
    User findByPhone(@Param(value ="phone") Integer phone);

}
