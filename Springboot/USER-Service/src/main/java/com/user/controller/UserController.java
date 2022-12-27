package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.service.IUserDetailsService;
import com.user.validator.UserValidator;

@RestController
//@RequestMapping("/api/v1/digitalbooks")
public class UserController {

    @GetMapping("/api/v1/digitalbooks/sign/{id}")
    public Integer authenticateUser1(@PathVariable Integer id){
     
        return id;
    }
    
}