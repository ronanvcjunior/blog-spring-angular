package com.ronan.blogspringangular.repository;

import com.ronan.blogspringangular.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
