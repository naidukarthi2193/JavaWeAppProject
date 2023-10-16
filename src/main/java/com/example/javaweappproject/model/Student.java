package com.example.javaweappproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private String suid;
    private String name;
    private String contactInfo;

    public Student() {
    }

    public Student(String suid, String name, String contactInfo) {
        this.suid = suid;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    // Getters and setters
    public String getSuid() {
        return suid;
    }

    public void setSuid(String suid) {
        this.suid = suid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
