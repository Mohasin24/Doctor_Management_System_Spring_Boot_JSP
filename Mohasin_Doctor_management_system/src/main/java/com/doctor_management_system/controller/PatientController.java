package com.doctor_management_system.controller;

import com.doctor_management_system.entity.Patient;
import com.doctor_management_system.service.PatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController
{
    private PatientDao patientDao;

    @Autowired
    public PatientController(PatientDao patientDao){
        this.patientDao=patientDao;
    }

    @GetMapping("patientLogin")
    public String patientLogin(){

        return "views/patientLogin";
    }

    @GetMapping("patientRegistration")
    public String patientRegistration(){

        return "views/patientRegistration";
    }


    @GetMapping("/patient-id/{patientId}")
    public Patient getPatientById(@PathVariable long patientId){
        return patientDao.getPatientById(patientId);
    }
    @GetMapping("/all")
    public List<Patient> getAllPatients(){
        return patientDao.getAllPatient();
    }
    @PostMapping("/add")
    public Patient addPatient(@RequestBody Patient patient){
        return patientDao.addPatient(patient);
    }
    @PutMapping("/update")
    public Patient updatePatient(@RequestBody Patient patient){
        return patientDao.updatePatient(patient);
    }
    @DeleteMapping("/remove/{patientId}")
    public void removePatientById(@PathVariable long patientId )
    {
        patientDao.deletePatientById(patientId);
    }
}
