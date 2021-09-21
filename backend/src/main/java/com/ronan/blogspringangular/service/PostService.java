package com.ronan.blogspringangular.service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.ronan.blogspringangular.domain.Post;
import com.ronan.blogspringangular.dto.PostDto;
import com.ronan.blogspringangular.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.security.core.userdetails.User;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    @Autowired
    private AuthService service;

    @Transactional
    public Post createPost(PostDto postDto) {
        Post post = mapFromDtoToPost(postDto);

        return repository.save(post);
    }

    private Post mapFromDtoToPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());

        User user = service.geCurrentUser().orElseThrow(() -> 
            new IllegalArgumentException("Usuário não logado")
        );

        post.userName(user.getUsername());
        post.createdOn(Instant.now());

        return post;
    }

    @Transactional
    public List<PostDto> getAllPosts() {
        List<Post> posts = repository.findAll();

        return posts.stream().map(this::mapFromPostToDto).collect(Collectors.toList());
    }

    @Transactional
      public PostDto getPostById(Long id) {
        Post post = repository.getById(id);
        PostDto postDto = mapFromPostToDto(post);
        return postDto;
    }

    private PostDto mapFromPostToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setUserName(post.getUserName());

        return postDto;
    }
}
