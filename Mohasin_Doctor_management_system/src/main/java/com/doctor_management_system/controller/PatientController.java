package com.doctor_management_system.controller;

import com.doctor_management_system.entity.Doctor;
import com.doctor_management_system.entity.Patient;
import com.doctor_management_system.service.PatientDao;
import com.doctor_management_system.utility.DoctorUtility;
import com.doctor_management_system.utility.LoginDetails;
import com.doctor_management_system.utility.PatientUtility;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PatientController
{
    private PatientDao patientDao;

    @Autowired
    public PatientController(PatientDao patientDao){
        this.patientDao=patientDao;
    }

    @GetMapping("/patientLogin")
    public String patientLogin(){

        return "patientLogin";
    }

    @PostMapping("/validate-patientLogin")
    public ModelAndView validatePatientLogin(@ModelAttribute LoginDetails loginDetails, HttpServletRequest request) {

        ModelAndView mv = new ModelAndView();

        Patient patient = patientDao.getPatientByEmail(loginDetails.email());

        HttpSession session = request.getSession();;
        if (patient != null && patient.getPassword().equals(loginDetails.password())) {

            session.setAttribute("patient", patient);
            session.setAttribute("status", "Patient logged in successfully");
            session.setAttribute("patientFirstName",patient.getName());
            mv.setViewName("redirect:patientHome");

        } else if (patient != null && !patient.getPassword().equals(loginDetails.password()))
        {
            session.setAttribute("status", "Incorrect Password");

            mv.setViewName("redirect:patientLogin");

        } else {
            session.setAttribute("status", "Patient not registered");

            mv.setViewName("redirect:patientRegistration");
        }

        return mv;
    }



    @GetMapping("/patientRegistration")
    public String patientRegistration(){
        return "patientRegistration";
    }

    @PostMapping("/validate-patientRegistration")
    public String validatePatientRegistration(@ModelAttribute PatientUtility patientRegistration){

        Patient patient = new Patient();

        patient.setName(patientRegistration.patientName());
        patient.setEmail(patientRegistration.patientEmail());
        patient.setGender(patientRegistration.patientGender());
        patient.setMobileNo(patientRegistration.patientMobile());
        patient.setPassword(patientRegistration.patientPassword());
        patient.setAppointmentList(new ArrayList<>());

        patientDao.addPatient(patient);

        return "redirect:patientLogin";
    }

    @GetMapping("/patientHome")
    public String patientHome(){
        return "patientHome";
    }

    @GetMapping("/patientProfile")
    public String patientProfile(){
        return "patientProfile";
    }

    @PostMapping("/patientProfileUpdate")
    public ModelAndView patientProfileUpdate(@ModelAttribute PatientUtility patientUtility, HttpServletRequest request){
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession();

        Patient patient = patientDao.getPatientById(patientUtility.patientId());

        patient.setName(patientUtility.patientName());
        patient.setEmail(patientUtility.patientEmail());
        patient.setMobileNo(patientUtility.patientMobile());
        patient.setAppointmentList(new ArrayList<>());
        patient.setPassword(patient.getPassword());

        patientDao.updatePatient(patient);

        mv.setViewName("redirect:/patientProfile");
        session.setAttribute("patient",patient);
        session.setAttribute("patientFirstName",patient.getName());
        session.setAttribute("status","Profile updated successfully!");
        return mv;
    }

//###########################################################################################
//                                   Rest Api's
//###########################################################################################

    @GetMapping("/patient-id/{patientId}")
    public Patient getPatientById(@PathVariable long patientId){
        return patientDao.getPatientById(patientId);
    }
    @GetMapping("/all-patient")
    public List<Patient> getAllPatients(){
        return patientDao.getAllPatient();
    }
    @PostMapping("/add-patient")
    public Patient addPatient(@RequestBody Patient patient){
        return patientDao.addPatient(patient);
    }
    @PutMapping("/update-patient")
    public Patient updatePatient(@RequestBody Patient patient){
        return patientDao.updatePatient(patient);
    }
    @DeleteMapping("/remove/{patientId}")
    public void removePatientById(@PathVariable long patientId )
    {
        patientDao.deletePatientById(patientId);
    }
}
