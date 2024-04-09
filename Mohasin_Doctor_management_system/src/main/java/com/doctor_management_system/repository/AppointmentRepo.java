package com.doctor_management_system.repository;

import com.doctor_management_system.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepo extends JpaRepository<Appointment, Long>
{
    //custom queries

    List<Appointment> findAllAppointmentByDoctorId(long id);
    List<Appointment> findAllAppointmentByPatientId(long id);
}
