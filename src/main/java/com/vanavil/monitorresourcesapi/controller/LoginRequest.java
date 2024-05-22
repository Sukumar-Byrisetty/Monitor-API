// LoginRequest.java
package com.vanavil.monitorresourcesapi.controller;

public class LoginRequest {
    private String mobileNumber;
    private String password;

    // Constructors, getters, and setters
    public LoginRequest() {
    }

    public LoginRequest(String mobileNumber, String password) {
        this.mobileNumber = mobileNumber;
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
