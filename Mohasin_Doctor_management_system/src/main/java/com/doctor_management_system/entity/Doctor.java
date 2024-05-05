package com.doctor_management_system.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Doctor_Dtls")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "availability")
    private String availability;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointmentList;


    public Doctor() {
    }

    public Doctor(Record doctor){}

    public Doctor(String name, String specialization, String availability, String email, String mobileNo) {
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
        this.email = email;
        this.mobileNo = mobileNo;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", availability='" + availability + '\'' +
                ", email='" + email + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
