package com.ronan.blogspringangular.service;

import com.ronan.blogspringangular.domain.User;
import com.ronan.blogspringangular.dto.LoginRequest;
import com.ronan.blogspringangular.dto.RegisterRequest;
import com.ronan.blogspringangular.repository.UserRepository;
import com.ronan.blogspringangular.security.JwtProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    public User signup(RegisterRequest registerRequest) {
        // User user = UserMapper.INSTANCE.toUser(registerRequest);
        User user = new User();
        signupDate(user, registerRequest);
        return repository.save(user);
    }

    private void signupDate(User user, RegisterRequest registerRequest) {
        user.setUserName(registerRequest.getUserName());
        user.setPassword(encodePassword(registerRequest.getPassword()));
        user.setEmail(registerRequest.getEmail());
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public String login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtProvider.generateToken(authentication);
    }

}
