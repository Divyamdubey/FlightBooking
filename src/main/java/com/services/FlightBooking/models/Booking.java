package com.services.FlightBooking.models;

import javax.persistence.*;

@Entity
@Table(name = "bokkings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "pnr")
    private String pnr;
    @Column(name = "flightNo")
    private String flightNo;
    @Column(name = "userEmail")
    private  String userEmail;

    public Booking() {
    }

    public Booking(Integer id, String pnr, String flightNo, String userEmail) {
        this.id = id;
        this.pnr = pnr;
        this.flightNo = flightNo;
        this.userEmail = userEmail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
