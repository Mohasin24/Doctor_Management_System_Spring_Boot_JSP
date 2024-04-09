package com.doctor_management_system.controller;

import com.doctor_management_system.entity.Appointment;
import com.doctor_management_system.service.AppointmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController
{
    private AppointmentDao appointmentDao;
    @Autowired
    public AppointmentController(AppointmentDao appointmentDao){
        this.appointmentDao=appointmentDao;
    }

    @GetMapping("/all-appointments")
    public List<Appointment> getAllAppointments(){
        return appointmentDao.getAllAppointments();
    }

    @GetMapping("/appointment-id/{appointmentId}")
    public Appointment getAppointmentById(@PathVariable long appointmentId){
        return appointmentDao.getAppointmentById(appointmentId);
    }
    @GetMapping("/appointment-doctor/{doctorId}")
    public List<Appointment> getAppointmentByDoctor(@PathVariable long doctorId){
        return appointmentDao.getAllAppointmentsByDoctor(doctorId);
    }

    @GetMapping("/appointment-patient/{patientId}")
    public List<Appointment> getAppointmentByPatient(@PathVariable long patientId){
        return appointmentDao.getAllAppointmentsByPatient(patientId);
    }

    @PostMapping("/create-appointment")
    public Appointment createAppointment(@RequestBody Appointment appointment){
        return appointmentDao.bookAppointment(appointment);
    }
    @DeleteMapping("/cancel-appointment/{appointmentId}")
    public void cancelAppointment(@PathVariable long appointmentId){
        appointmentDao.cancelAppointment(appointmentId);
    }

}
