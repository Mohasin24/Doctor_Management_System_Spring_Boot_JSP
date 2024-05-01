package com.doctor_management_system.controller;

import com.doctor_management_system.service.DoctorDao;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class MainController
{
    private DoctorDao doctorDao;
    @Autowired
    public MainController(DoctorDao doctorDao){
        this.doctorDao=doctorDao;
    }
    @RequestMapping(path = {"/", "/home"})
    public String home(){
        return "home";

    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session){

        ModelAndView mv = new ModelAndView();

        if(session!=null){
            session.setAttribute("status", "Logged out successfully");
            session.invalidate();
        }
        mv.setViewName("redirect:/home");
        return mv;
    }

    @RequestMapping("/test")
    public ModelAndView test(Model model){
        ModelAndView mv = new ModelAndView();

        mv.addObject("name","Mohasin Khalil Patel");
        mv.setViewName("test");

        return mv;

//        model.addAttribute("name","Mohasin Patel");
//
//        return "test";


    }


}
