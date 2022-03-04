package com.services.FlightBooking.repository;

import com.services.FlightBooking.models.Admin;
import com.services.FlightBooking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer> {

    @Query(value = "select a from Admin a where a.adminName= :adminName")
    Admin findByAdminName(@Param(value = "adminName") String adminName);
}
