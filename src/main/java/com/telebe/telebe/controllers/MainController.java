package com.telebe.telebe.controllers;

import com.telebe.telebe.models.ERole;
import com.telebe.telebe.models.Role;
import com.telebe.telebe.models.User;
import com.telebe.telebe.repository.RoleRepository;
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

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    //test ucun olduguna gore auth yazmadim
    @PostMapping("/test/create/studentRole")
    public String createRole() {
        Role role = new Role();
        role.setName(ERole.ROLE_STUDENT);
        roleRepository.save(role);
        return "Student Role created";
    }

    @GetMapping("/user/{id}")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public Optional<User> userInfo(@PathVariable("id") Long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

}
