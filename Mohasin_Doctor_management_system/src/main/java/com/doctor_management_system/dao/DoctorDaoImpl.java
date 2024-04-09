package com.doctor_management_system.dao;

import com.doctor_management_system.entity.Doctor;
import com.doctor_management_system.repository.DoctorRepo;
import com.doctor_management_system.service.DoctorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorDaoImpl implements DoctorDao {

    private DoctorRepo doctorRepo;

    @Autowired
    public DoctorDaoImpl(DoctorRepo doctorRepo){
        this.doctorRepo=doctorRepo;
    }

    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    @Override
    public void deleteDoctorById(long id) {
        doctorRepo.deleteById(id);
    }

    @Override
    public Doctor getDoctorById(long id) {
        return doctorRepo.findById(id).get();
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    @Override
    public Doctor getDoctorBySpecialization(String specialization) {
        return doctorRepo.findBySpecialization(specialization);
    }
}
