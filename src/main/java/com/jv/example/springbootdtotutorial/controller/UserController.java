package com.jv.example.springbootdtotutorial.controller;

import com.jv.example.springbootdtotutorial.dto.UserLocationDTO;
import com.jv.example.springbootdtotutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users-location")
    public List<UserLocationDTO> getAllUsersLocation(){
        return userService.getAllUsersLocations();
    }
}
