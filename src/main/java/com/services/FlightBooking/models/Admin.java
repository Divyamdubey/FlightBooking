package com.services.FlightBooking.models;

import javax.persistence.*;

@Entity
@Table(name = "admin_login")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;

    public Admin() {
    }

    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        this.Id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
