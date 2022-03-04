package com.services.FlightBooking.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @Column(name = "flight_no")
    private String flightNo;
    @Column(name = "flight_name")
    private String flightName;
    @Column(name = "departure_from")
    private String departureFrom;
    @Column(name = "arrival_to")
    private String arrivalTo;
    @Column(name = "departure_date")
    private String departureDate;
    @Column(name = "arrival_date")
    private String arrivalDate;
    @Column(name = "status")
    private String status;
    @Column(name = "cost")
    private Integer cost;
    @Column(name = "total_seat")
    private Integer totalSeats;
    @Column(name = "discount_code")
    private String discountCode;

    public Flight() {
    }

    public Flight(String flightNo, String flightName, String departureFrom, String arrivalTo,
                  String departureDate, String arrivalDate, String status, Integer cost,
                  Integer totalSeats, String discountCode) {
        this.flightNo = flightNo;
        this.flightName = flightName;
        this.departureFrom = departureFrom;
        this.arrivalTo = arrivalTo;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.status = status;
        this.cost = cost;
        this.totalSeats = totalSeats;
        this.discountCode = discountCode;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getDepartureFrom() {
        return departureFrom;
    }

    public void setDepartureFrom(String departureFrom) {
        this.departureFrom = departureFrom;
    }

    public String getArrivalTo() {
        return arrivalTo;
    }

    public void setArrivalTo(String arrivalTo) {
        this.arrivalTo = arrivalTo;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }
}
