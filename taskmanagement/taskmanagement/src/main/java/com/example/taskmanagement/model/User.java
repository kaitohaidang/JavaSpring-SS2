package com.example.taskmanagement.model;

import com.example.taskmanagement.service.UserService;

public class User {
    private int id;
    private String username;
    private String email;
    private String role;
    public User() {
    }
    public User(int id ,String username, String email,String role) {
        this.id=id;
        this.username=username;
        this.email=email;
        this.role=role;
    }
    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getUsername() {
        return username;
    }
    public String getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
