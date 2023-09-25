package com.demo.controller;

import com.demo.entity.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }



    @GetMapping("/all")
    @PreAuthorize("hasAuthority('Admin')")
    public List<User> getAllTheProducts() {
        return service.getAll();
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('user','Admin')") // Correct if the role is "user"

    public User getProductById() {
        return service.getUserDetails();
    }
}
