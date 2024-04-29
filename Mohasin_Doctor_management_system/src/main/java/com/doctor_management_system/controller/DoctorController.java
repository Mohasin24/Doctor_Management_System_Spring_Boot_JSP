package com.doctor_management_system.controller;

import com.doctor_management_system.entity.Doctor;
import com.doctor_management_system.service.DoctorDao;
import com.doctor_management_system.utility.DoctorRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DoctorController
{
    private DoctorDao doctorDao;
    @Autowired
    public DoctorController(DoctorDao doctorDao){
        this.doctorDao=doctorDao;
    }


    @GetMapping("/doctorLogin")
    public String doc(){
        return "doctorLogin";
    }

    @PostMapping("/validate-doctorLogin")
    public String validateDoctorLogin(){
        return "redirect:doctorHome";
    }

    @GetMapping("/doctorRegistration")
    public String doctorRegister(){
        return "doctorRegistration";
    }

    @PostMapping("/validate-doctorRegistration")
    public String validateDoctorRegistration(@ModelAttribute DoctorRegistration doctorRegistration){

        Doctor doctor = new Doctor();
        doctor.setName(doctorRegistration.doctorName());
        doctor.setEmail(doctorRegistration.doctorEmail());
        doctor.setMobileNo(doctorRegistration.doctorMobile());
        doctor.setSpecialization(doctorRegistration.doctorSpecialty());
        doctor.setAvailability(doctorRegistration.doctorAvailability());
        doctor.setAppointmentList(new ArrayList<>());
        doctor.setPassword(doctorRegistration.doctorPassword());

        doctorDao.addDoctor(doctor);

        return "redirect:doctorLogin";

    }














//######################################################################




    @GetMapping("/doctor-id/{doctorId}")
    public Doctor getDoctorById(@PathVariable long doctorId){
        return doctorDao.getDoctorById(doctorId);
    }
    @GetMapping("/doctor-specialization/{specialization}")
    public Doctor getDoctorBySpecialization(@PathVariable String specialization){
        return doctorDao.getDoctorBySpecialization(specialization);
    }
    @GetMapping("/all-doctor")
    public List<Doctor> getAllDoctors(){
        return doctorDao.getAllDoctors();
    }
    @PostMapping("/-doctor")
    public Doctor addDoctor(@RequestBody Doctor doctor){
        return doctorDao.addDoctor(doctor);
    }
    @PutMapping("/update-doctor")
    public Doctor updateDoctor(@RequestBody Doctor doctor){

        return doctorDao.updateDoctor(doctor);
    }
    @DeleteMapping("/remove/{doctorId}")
    public void removeDoctor(@PathVariable long doctorId){
        doctorDao.deleteDoctorById(doctorId);
    }

}
