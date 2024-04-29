package com.doctor_management_system.dao;

import com.doctor_management_system.entity.Patient;
import com.doctor_management_system.repository.PatientRepo;
import com.doctor_management_system.service.PatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientDaoImpl implements PatientDao {

    private PatientRepo patientRepo;
    @Autowired
    public PatientDaoImpl(PatientRepo patientRepo){
        this.patientRepo=patientRepo;
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepo.save(patient);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepo.save(patient);
    }

    @Override
    public void deletePatientById(long id) {
        patientRepo.deleteById(id);
    }

    @Override
    public Patient getPatientById(long id) {
        return patientRepo.findById(id).get();
    }

    @Override
    public Patient getPatientByEmail(String email) {
        return patientRepo.findByEmail(email);
    }

    @Override
    public List<Patient> getAllPatient() {
        return patientRepo.findAll();
    }
}
