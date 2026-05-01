package com.example.taskmanagement.controller;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.model.User;
import com.example.taskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {
    private final TaskService taskService ;
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService=taskService;
    }
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(@RequestParam(required = false) String search) {
        List<Task> filteredTasks = taskService.findAllTasks().stream()
                .filter(task -> task.getTitle().toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(filteredTasks);
    }
}
