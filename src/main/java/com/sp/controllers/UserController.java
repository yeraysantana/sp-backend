package com.sp.controllers;

import com.sp.entities.User;
import com.sp.services.users.IUserService;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public Iterable<User> getUsers(){
        logger.info("-> UserController getUsers...");
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable Long id){
        logger.info("-> UserController getUserId: " + id);
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        logger.info("-> UserController addUser... "+ user);
        return userService.addUser(user);
    }
}
