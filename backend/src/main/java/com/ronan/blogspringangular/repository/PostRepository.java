package com.ronan.blogspringangular.repository;

import com.ronan.blogspringangular.domain.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    
}
