package com.ronan.blogspringangular.dto;

public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String userName;


    public PostDto() {
    }

    public PostDto(Long id, String title, String content, String userName) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userName = userName;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public PostDto id(Long id) {
        setId(id);
        return this;
    }

    public PostDto title(String title) {
        setTitle(title);
        return this;
    }

    public PostDto content(String content) {
        setContent(content);
        return this;
    }

    public PostDto userName(String userName) {
        setUserName(userName);
        return this;
    }
}
