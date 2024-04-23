package com.doctor_management_system.entity;

import com.doctor_management_system.constants.AppointmentStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "appointment_time_date")
    private LocalDateTime localDateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "appointment_status",nullable = false)
    private AppointmentStatus status;

    public Appointment() {
    }

    public Appointment(Doctor doctor, Patient patient, LocalDateTime localDateTime, AppointmentStatus status) {
        this.doctor = doctor;
        this.patient = patient;
        this.localDateTime = localDateTime;
        this.status = status;
    }

    public long getId() {
        return id;
    }
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", doctor=" + doctor +
                ", patient=" + patient +
                ", localDateTime=" + localDateTime +
                ", status=" + status +
                '}';
    }
}
