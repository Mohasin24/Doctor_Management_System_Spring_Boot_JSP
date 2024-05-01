package com.doctor_management_system.controller;

import com.doctor_management_system.entity.Doctor;
import com.doctor_management_system.service.DoctorDao;
import com.doctor_management_system.utility.DoctorRegistration;
import com.doctor_management_system.utility.LoginDetails;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView validateDoctorLogin(@ModelAttribute LoginDetails loginDetails, HttpServletRequest request)
    {
        ModelAndView mv = new ModelAndView();

        Doctor doctor = doctorDao.getDoctorByEmail(loginDetails.email());

        if(doctor != null && doctor.getPassword().equals(loginDetails.password())){
            HttpSession session = request.getSession();
            session.setAttribute("doctor",doctor);
            session.setAttribute("doctorName",doctor.getName());

            mv.addObject("status","Doctor Successfully logged in.");
            mv.setViewName("redirect:/doctorHome");

        } else if(doctor != null && !doctor.getPassword().equals(loginDetails.password())){
            mv.addObject("status","Incorrect Password");
            mv.setViewName("redirect:/doctorLogin");
        } else{
            mv.addObject("status","Doctor not registered");
            mv.setViewName("redirect:doctorRegistration");
        }

        return mv;
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

    @GetMapping("/doctorHome")
    public String patientHome(){
        return "doctorHome";
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
