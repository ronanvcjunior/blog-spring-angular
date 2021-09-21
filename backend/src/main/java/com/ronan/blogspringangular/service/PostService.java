package com.ronan.blogspringangular.service;

import java.time.Instant;

import com.ronan.blogspringangular.domain.Post;
import com.ronan.blogspringangular.dto.PostDto;
import com.ronan.blogspringangular.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    @Autowired
    private AuthService service;

    public Post createPost(PostDto postDto) {
        Post post = new Post();
        createPostDate(post, postDto);

        return repository.save(post);
    }

    private void createPostDate(Post post, PostDto postDto) {
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());

        User user = service.geCurrentUser().orElseThrow(() -> 
            new IllegalArgumentException("Usuário não logado")
        );

        post.userName(user.getUsername());
        post.createdOn(Instant.now());
    }
}
