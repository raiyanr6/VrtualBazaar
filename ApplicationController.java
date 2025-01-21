package com.example.demo.Application;

import com.example.demo.Application.User;
import com.example.demo.Application.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestParam String userId, @RequestParam String name, @RequestParam String role) {
        return ResponseEntity.ok(applicationService.registerUser(userId, name, role));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        return ResponseEntity.ok(applicationService.getUser(userId));
    }
}
