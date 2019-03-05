package com.example.schoolmanagementserver.SchoolManagement.Domain.Authentication;

import java.io.Serializable;

public class LoginCreds implements Serializable {
    private String password;
    private String username;

    public LoginCreds(String username, String password) {
        this.password = password;
        this.username = username;
    }

    public LoginCreds() {

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
