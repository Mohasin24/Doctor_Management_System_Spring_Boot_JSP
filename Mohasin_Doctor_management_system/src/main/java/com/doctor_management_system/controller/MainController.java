package com.doctor_management_system.controller;

import com.doctor_management_system.service.DoctorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MainController
{
    private DoctorDao doctorDao;
    @Autowired
    public MainController(DoctorDao doctorDao){
        this.doctorDao=doctorDao;
    }
    @RequestMapping(path = {"/", "/home"})
    public String test(){
        return "home";

    }




}
