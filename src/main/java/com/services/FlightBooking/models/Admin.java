package com.services.FlightBooking.models;

import javax.persistence.*;

@Entity
@Table(name = "admin_login")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer adminId;

    @Column(name = "admin_name")
    private String adminName;
    @Column(name = "admin_password")
    private String adminPassword;


    public Admin() {
    }

    public Admin(Integer adminId, String adminName,String adminPassword) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
