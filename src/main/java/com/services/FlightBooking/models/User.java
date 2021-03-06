package com.services.FlightBooking.models;

import javax.persistence.*;

@Entity
@Table(name = "user_login")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="user_id" )
    private Integer id;

    @Column(name="user_first_name",nullable = false)
    private String firstName;
    @Column(name="user_last_name",nullable = false)
    private String lastName;
    @Column(name="user_pwd",nullable = false)
    private String password;
    @Column(name="user_phone",unique = true,nullable = false)
    private Long phone;
    @Column(name="user_mail",unique = true,nullable = false)
    private String email;


    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
