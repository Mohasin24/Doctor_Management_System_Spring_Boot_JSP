package com.doctor_management_system.service;

import com.doctor_management_system.entity.Patient;

import java.util.List;

public interface PatientDao
{
    Patient addPatient(Patient patient);
    Patient updatePatient(Patient patient);
    void deletePatientById(long id);
    Patient getPatientById(long id);
    Patient getPatientByEmail(String email);
    List<Patient> getAllPatient();
}
