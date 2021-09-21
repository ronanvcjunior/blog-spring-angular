package com.ronan.blogspringangular.controller;

import java.util.List;

import com.ronan.blogspringangular.domain.Post;
import com.ronan.blogspringangular.dto.PostDto;
import com.ronan.blogspringangular.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService service;
    
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostDto postDto) {
        Post post = service.createPost(postDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = service.getAllPosts();
        return ResponseEntity.ok().body(posts);
    }
}
