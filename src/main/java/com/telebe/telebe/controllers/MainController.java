package com.telebe.telebe.controllers;

import com.telebe.telebe.models.User;
import com.telebe.telebe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Optional<User> userInfo(@PathVariable("id") Long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

}
