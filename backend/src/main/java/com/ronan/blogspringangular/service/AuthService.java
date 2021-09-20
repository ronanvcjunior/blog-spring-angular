package com.ronan.blogspringangular.service;

import com.ronan.blogspringangular.domain.User;
import com.ronan.blogspringangular.dto.RegisterRequest;
import com.ronan.blogspringangular.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User signup(RegisterRequest registerRequest) {
        // User user = UserMapper.INSTANCE.toUser(registerRequest);
        User user = new User();
        signupDate(user, registerRequest);
        return userRepository.save(user);
    }

    private void signupDate(User user, RegisterRequest registerRequest) {
        user.setUserName(registerRequest.getUserName());
        user.setPassword(encodePassword(registerRequest.getPassword()));
        user.setEmail(registerRequest.getEmail());
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
    
}
