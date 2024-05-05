package com.doctor_management_system.repository;

import com.doctor_management_system.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {

    //custom implementation
    Doctor findBySpecialization(String specialization);

    //    find the doctor by email address
    Doctor findByEmail(String email);

    @Query("Select distinct specialization from Doctor")
    Set<String> findAllSpecialization();
}
