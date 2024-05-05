package com.doctor_management_system.service;

import com.doctor_management_system.entity.Doctor;
import com.doctor_management_system.entity.Patient;

import java.util.List;
import java.util.Set;

public interface DoctorDao
{
    Doctor addDoctor(Doctor doctor);
    Doctor updateDoctor(Doctor doctor);
    void deleteDoctorById(long id);
    Doctor getDoctorById(long id);
    Doctor getDoctorByEmail(String email);
    List<Doctor> getAllDoctors();
    Doctor getDoctorBySpecialization(String specialization);

    Set<String> getAllDoctorSpecialization();
}
