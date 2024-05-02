package com.example.demo.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Login;
import com.example.demo.repository.LogRepo;

@Service
public class LogService {

    @Autowired
    private LogRepo rep;

    public String login(String username, String password) {
        Login found = rep.findByUsernameAndPassword(username, password);
        if(Objects.nonNull(found)) {
            return found.getUsername();
        }
        return null;
    }
    
}
