package com.services.FlightBooking.models;

public class Passanger {
    private String userId;
    private String firstName;
    private String lastName;
    private String pnr;
    private String userAge;
    private String userGender;
    private String userMail;
    private String userMealType;
    private String userSeatNo;
    private String userCost;
    private String userBookingMail;

    public Passanger() {
    }

    public Passanger(String userId, String firstName, String lastName, String pnr, String userAge, String userGender,
                     String userMail, String userMealType, String userSeatNo, String userCost, String userBookingMail) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pnr = pnr;
        this.userAge = userAge;
        this.userGender = userGender;
        this.userMail = userMail;
        this.userMealType = userMealType;
        this.userSeatNo = userSeatNo;
        this.userCost = userCost;
        this.userBookingMail = userBookingMail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserMealType() {
        return userMealType;
    }

    public void setUserMealType(String userMealType) {
        this.userMealType = userMealType;
    }

    public String getUserSeatNo() {
        return userSeatNo;
    }

    public void setUserSeatNo(String userSeatNo) {
        this.userSeatNo = userSeatNo;
    }

    public String getUserCost() {
        return userCost;
    }

    public void setUserCost(String userCost) {
        this.userCost = userCost;
    }

    public String getUserBookingMail() {
        return userBookingMail;
    }

    public void setUserBookingMail(String userBookingMail) {
        this.userBookingMail = userBookingMail;
    }
}
