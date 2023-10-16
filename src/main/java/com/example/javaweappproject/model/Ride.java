package com.example.javaweappproject.model;

public class Ride {
    private String suid;
    private String address;

    public Ride() {
    }

    public Ride(String suid, String address) {
        this.suid = suid;
        this.address = address;
    }

    // Getters and setters
    public String getSuid() {
        return suid;
    }

    public void setSuid(String suid) {
        this.suid = suid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
