package com.doctor_management_system.repository;

import com.doctor_management_system.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient,Long> {

//    find the patient by email address
    public Patient findByEmail(String email);
}
