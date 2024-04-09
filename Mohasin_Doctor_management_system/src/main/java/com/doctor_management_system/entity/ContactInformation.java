package com.doctor_management_system.entity;

import jakarta.persistence.Entity;


public class ContactInformation {
    private String mobileNo;
    private String email;

    public ContactInformation(){}

    public ContactInformation(String mobileNo, String email){
        this.email = email;
        this.mobileNo = mobileNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ContactInformation{" +
                "mobileNo='" + mobileNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
