package com.example.taskmanagement.controller;

import com.example.taskmanagement.model.User;
import com.example.taskmanagement.service.TaskService;
import com.example.taskmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService=userService;
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userService.fillAllUsers();
    }
}
