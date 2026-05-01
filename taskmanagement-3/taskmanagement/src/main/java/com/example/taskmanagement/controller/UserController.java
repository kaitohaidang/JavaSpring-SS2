package com.example.taskmanagement.controller;

import com.example.taskmanagement.model.User;
import com.example.taskmanagement.service.TaskService;
import com.example.taskmanagement.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService=userService;
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String search) {
        List<User> allUsers = userService.fillAllUsers();

        if (search == null || search.trim().isEmpty()) {
            return ResponseEntity.ok(allUsers);
        }
        List<User> userList = allUsers.stream()
                .filter(user -> user.getUsername() != null && user.getUsername().toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(userList);
    }
}
