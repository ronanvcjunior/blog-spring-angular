package com.ronan.blogspringangular.service;

import java.util.Collection;
import java.util.Collections;

import com.ronan.blogspringangular.domain.User;
import com.ronan.blogspringangular.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = repository.findByUserName(userName).orElseThrow(() -> 
                new UsernameNotFoundException("O Usuário" + userName + "não foi encontrado"));
        return new org.springframework.security.core.userdetails.User(
                user.getUserName(), user.getPassword(), true, true, true, true, getAuthorities("ROLE_USER"));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role_user) {
        return Collections.singletonList(new SimpleGrantedAuthority(role_user));
    }
}
