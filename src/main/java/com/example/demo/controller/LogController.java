package com.example.demo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.domain.Login;
import com.example.demo.service.LogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LogController {

    @Autowired
    private LogService service;

    @GetMapping("/")
    public String api() {
        return "index";
    }
    
    @PostMapping("/log")
    public String login(@ModelAttribute Login user) {
       String oathuser =  service.login(user.getUsername(), user.getPassword());
       if(Objects.nonNull(oathuser))
       {
        return "disp";
       }
       else{
        return "/";
       }
    }

    @GetMapping("/disp")
    public String display() {
        return "dispay";
    }
    
    
    
}