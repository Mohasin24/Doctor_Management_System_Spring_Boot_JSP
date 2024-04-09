package com.doctor_management_system.service;

import com.doctor_management_system.entity.Doctor;

import java.util.List;

public interface DoctorDao
{
    Doctor addDoctor(Doctor doctor);
    Doctor updateDoctor(Doctor doctor);
    void deleteDoctorById(long id);
    Doctor getDoctorById(long id);
    List<Doctor> getAllDoctors();
    Doctor getDoctorBySpecialization(String specialization);
}
