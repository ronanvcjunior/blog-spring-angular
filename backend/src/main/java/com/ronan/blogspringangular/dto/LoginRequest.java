package com.ronan.blogspringangular.dto;

public class LoginRequest {

    private String userName;
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
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

    public LoginRequest userName(String userName) {
        setUserName(userName);
        return this;
    }

    public LoginRequest password(String password) {
        setPassword(password);
        return this;
    }
}
