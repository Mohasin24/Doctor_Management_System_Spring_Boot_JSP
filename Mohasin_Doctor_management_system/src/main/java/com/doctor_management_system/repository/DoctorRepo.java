package com.doctor_management_system.repository;

import com.doctor_management_system.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {

    //custom implementation
    Doctor findBySpecialization(String specialization);

    //    find the doctor by email address
    public Doctor findByEmail(String email);
}
