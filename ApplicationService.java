package com.example.demo.Application;

import com.example.demo.Application.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ApplicationService {
    private final Map<String, User> users = new HashMap<>();

    public User registerUser(String userId, String name, String role) {
        User user = new User(userId, name, role);
        users.put(userId, user);
        return user;
    }

    public User getUser(String userId) {
        return users.get(userId);
    }
}
