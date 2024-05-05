package com.doctor_management_system.controller;

import com.doctor_management_system.entity.Doctor;
import com.doctor_management_system.service.DoctorDao;
import com.doctor_management_system.utility.DoctorUtility;
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
        HttpSession session = request.getSession();

        if(doctor != null && doctor.getPassword().equals(loginDetails.password())){

            session.setAttribute("doctor",doctor);
            session.setAttribute("status","Doctor logged in successfully");
            session.setAttribute("doctorFirstName",doctor.getName());
            mv.setViewName("redirect:doctorHome");

        } else if(doctor != null && !doctor.getPassword().equals(loginDetails.password())){
            session.setAttribute("status","Incorrect Password");
            mv.setViewName("redirect:doctorLogin");
        } else{
            session.setAttribute("status","Doctor not registered");
            mv.setViewName("redirect:doctorRegistration");
        }

        return mv;
    }

    @GetMapping("/doctorRegistration")
    public String doctorRegister(){
        return "doctorRegistration";
    }

    @PostMapping("/validate-doctorUtility")
    public String validateDoctorRegistration(@ModelAttribute DoctorUtility doctorUtility){

        Doctor doctor = new Doctor();
        doctor.setName(doctorUtility.doctorName());
        doctor.setEmail(doctorUtility.doctorEmail());
        doctor.setMobileNo(doctorUtility.doctorMobile());
        doctor.setSpecialization(doctorUtility.doctorSpecialty());
        doctor.setAvailability(doctorUtility.doctorAvailability());
        doctor.setAppointmentList(new ArrayList<>());
        doctor.setPassword(doctorUtility.doctorPassword());

        doctorDao.addDoctor(doctor);

        return "redirect:doctorLogin";

    }

    @GetMapping("/doctorHome")
    public String patientHome(){
        return "doctorHome";
    }

    @GetMapping("/doctorProfile")
    public String doctorProfile(){
        return "doctorProfile";
    }

    @PostMapping("/doctorProfileUpdate")
    public ModelAndView doctorProfileUpdate(@ModelAttribute DoctorUtility doctorUtility, HttpServletRequest request){
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession();

        Doctor doctor = doctorDao.getDoctorById(doctorUtility.doctorId());

        doctor.setName(doctorUtility.doctorName());
        doctor.setEmail(doctorUtility.doctorEmail());
        doctor.setMobileNo(doctorUtility.doctorMobile());
        doctor.setSpecialization(doctorUtility.doctorSpecialty());
        doctor.setAvailability(doctorUtility.doctorAvailability());
        doctor.setAppointmentList(new ArrayList<>());
        doctor.setPassword(doctor.getPassword());

        doctorDao.updateDoctor(doctor);

        mv.setViewName("redirect:/doctorProfile");
        session.setAttribute("doctor",doctor);
        session.setAttribute("doctorFirstName",doctor.getName());
        session.setAttribute("status","Profile updated successfully!");
        return mv;
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
