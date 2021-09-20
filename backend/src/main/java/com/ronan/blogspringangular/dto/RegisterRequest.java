package com.ronan.blogspringangular.dto;

public class RegisterRequest {
    
    private String userName;
    private String password;
    private String email;

    public RegisterRequest() {
    }

    public RegisterRequest(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RegisterRequest userName(String userName) {
        setUserName(userName);
        return this;
    }

    public RegisterRequest password(String password) {
        setPassword(password);
        return this;
    }

    public RegisterRequest email(String email) {
        setEmail(email);
        return this;
    }
}
