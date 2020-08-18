package com.example.springsecurityjwt.mapper;

import java.io.Serializable;

public class AuthenticateRequest implements Serializable {

    private String username;
    private String password;

    public AuthenticateRequest(String userName, String password) {
        this.username = userName;
        this.password = password;
    }

    public AuthenticateRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
