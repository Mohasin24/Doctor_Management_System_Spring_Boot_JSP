package com.doctor_management_system.service;

import com.doctor_management_system.entity.Appointment;
import com.doctor_management_system.entity.Patient;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentDao
{
    Appointment bookAppointment(Appointment appointment);
    void cancelAppointment(long appointmentId);
    Appointment getAppointmentById(long id);

    List<Appointment> getAllAppointments();

    List<Appointment> getAllAppointmentsByDoctor(long doctorId);

    List<Appointment> getAllAppointmentsByPatient(long patientId);

}
