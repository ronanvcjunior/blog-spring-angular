package com.ronan.blogspringangular.domain;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@Table
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @Lob
    @NotEmpty
    private String content;

    private Instant createdOn;
    private Instant updateOn;

    @NotBlank
    @Column(name = "user_name")
    private String userName;

    public Post() {
    }

    public Post(Long id, String title, String content, Instant createdOn, Instant updateOn, String userName) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdOn = createdOn;
        this.updateOn = updateOn;
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

    public Instant getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Instant getUpdateOn() {
        return this.updateOn;
    }

    public void setUpdateOn(Instant updateOn) {
        this.updateOn = updateOn;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Post id(Long id) {
        setId(id);
        return this;
    }

    public Post title(String title) {
        setTitle(title);
        return this;
    }

    public Post content(String content) {
        setContent(content);
        return this;
    }

    public Post createdOn(Instant createdOn) {
        setCreatedOn(createdOn);
        return this;
    }

    public Post updateOn(Instant updateOn) {
        setUpdateOn(updateOn);
        return this;
    }

    public Post userName(String userName) {
        setUserName(userName);
        return this;
    }
}
