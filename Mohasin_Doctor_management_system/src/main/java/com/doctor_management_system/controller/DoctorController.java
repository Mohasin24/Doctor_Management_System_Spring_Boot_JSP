package com.doctor_management_system.controller;

import com.doctor_management_system.entity.Doctor;
import com.doctor_management_system.service.DoctorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController
{
    private DoctorDao doctorDao;
    @Autowired
    public DoctorController(DoctorDao doctorDao){
        this.doctorDao=doctorDao;
    }

    @GetMapping("/doctor-id/{doctorId}")
    public Doctor getDoctorById(@PathVariable long doctorId){
        return doctorDao.getDoctorById(doctorId);
    }
    @GetMapping("/doctor-specialization/{specialization}")
    public Doctor getDoctorBySpecialization(@PathVariable String specialization){
        return doctorDao.getDoctorBySpecialization(specialization);
    }
    @GetMapping("/all")
    public List<Doctor> getAllDoctors(){
        return doctorDao.getAllDoctors();
    }
    @PostMapping("/add")
    public Doctor addDoctor(@RequestBody Doctor doctor){
        return doctorDao.addDoctor(doctor);
    }
    @PutMapping("/update")
    public Doctor updateDoctor(@RequestBody Doctor doctor){
        return doctorDao.updateDoctor(doctor);
    }
    @DeleteMapping("/remove/{doctorId}")
    public void removeDoctor(@PathVariable long doctorId){
        doctorDao.deleteDoctorById(doctorId);
    }

}
