package com.example.taskmanagement.service;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.model.User;
import com.example.taskmanagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserService userService;
    @Autowired
    public TaskService(TaskRepository taskRepository,UserService userService) {
        this.taskRepository=taskRepository;
        this.userService=userService;
    }
    public Task addTask (Task task) {
        if (userService.findUserById(task.getAssignedTo())!=null) {
                taskRepository.findAll().add(task);
                return task;
        }
        return null;
    }
    public List<Task> findAllTasks() {
       return taskRepository.findAll();
    }
}
