package com.ronan.blogspringangular.controller;

import com.ronan.blogspringangular.domain.User;
import com.ronan.blogspringangular.dto.LoginRequest;
import com.ronan.blogspringangular.dto.RegisterRequest;
import com.ronan.blogspringangular.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService service;
    
    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody RegisterRequest registerRequest) {
        User user = service.signup(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return service.login(loginRequest);
    }
}
