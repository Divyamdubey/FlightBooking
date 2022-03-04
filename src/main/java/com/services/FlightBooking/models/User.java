package com.services.FlightBooking.models;

import javax.persistence.*;

@Entity
@Table(name = "user_login")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="user_id" )
    private Integer userId;

    @Column(name="user_first_name")
    private String userFirstName;
    @Column(name="user_last_name")
    private String userLastName;
    @Column(name="user_pwd")
    private String userPassword;
    @Column(name="user_mail")
    private String userEmail;
    @Column(name="user_phone")
    private Integer userPhone;

    public User() {
    }

    public User(Integer userId,String userFirstName,String userLastName, String userPassword, String userEmail,
                Integer userPhone) {
        super();
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
    }
    public User(String userFirstName,String userLastName, String userPassword, String userEmail,
                Integer userPhone) {
        super();
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Integer userPhone) {
        this.userPhone = userPhone;
    }
}
