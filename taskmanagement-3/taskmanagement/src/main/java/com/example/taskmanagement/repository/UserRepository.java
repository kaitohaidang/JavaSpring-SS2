package com.example.taskmanagement.repository;

import com.example.taskmanagement.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
@Repository
public class UserRepository {
    private final List<User> users= new ArrayList<>(Arrays.asList(
            new User(1, "nguyenvana", "a@example.com", "admin"),
            new User(2, "tranvanb", "b@example.com", "user"),
            new User(3, "lethic", "c@example.com", "manager")
    ));
    public List<User> findAll(){
        return users;
    }
    public User findById (int id) {
        return users.stream().filter(user -> user.getId()==id).findFirst().orElse(null);
    }
}
