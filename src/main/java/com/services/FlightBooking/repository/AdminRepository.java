package com.services.FlightBooking.repository;

import com.services.FlightBooking.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {

    @Query(value = "select a from Admin a where a.name= :name")
    Admin findByAdminName(@Param(value = "name") String name);
}
