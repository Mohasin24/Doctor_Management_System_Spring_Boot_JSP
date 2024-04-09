package com.doctor_management_system.dao;

import com.doctor_management_system.constants.AppointmentStatus;
import com.doctor_management_system.entity.Appointment;
import com.doctor_management_system.entity.Patient;
import com.doctor_management_system.repository.AppointmentRepo;
import com.doctor_management_system.service.AppointmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentDaoImpl implements AppointmentDao {

    private AppointmentRepo appointmentRepo;
    @Autowired
    public AppointmentDaoImpl(AppointmentRepo appointmentRepo){
        this.appointmentRepo=appointmentRepo;
    }
    @Override
    public Appointment bookAppointment(Appointment appointment) {
        appointment.setStatus(AppointmentStatus.BOOKED);
        return appointmentRepo.save(appointment);
    }

    @Override
    public void cancelAppointment(long appointmentId) {
        appointmentRepo.deleteById(appointmentId);
    }

    @Override
    public Appointment getAppointmentById(long id) {
        return appointmentRepo.findById(id).get();
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepo.findAll();
    }

    @Override
    public List<Appointment> getAllAppointmentsByDoctor(long doctorId) {
        return appointmentRepo.findAllAppointmentByDoctorId(doctorId);
    }

    @Override
    public List<Appointment> getAllAppointmentsByPatient(long patientId) {
        return appointmentRepo.findAllAppointmentByPatientId(patientId);
    }
}
