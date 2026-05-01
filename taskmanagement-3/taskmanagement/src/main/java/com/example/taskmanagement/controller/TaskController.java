package com.example.taskmanagement.controller;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.model.User;
import com.example.taskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        List<Task> tasks= taskService.findAllTasks();
        if (search == null || search.trim().isEmpty()) {
            return ResponseEntity.ok(tasks);
        }
        List<Task> filteredTasks = taskService.findAllTasks().stream()
                .filter(task -> task.getTitle().toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(filteredTasks);
    }
    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Task newTask) {
        Task createdTask = taskService.addTask(newTask);
        if (createdTask !=null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
        } else {
            return
                    ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lỗi: Người dùng được giao việc (assignedTo = " + newTask.getAssignedTo() + ") không tồn tại trong hệ thống!");
        }
    }
}
