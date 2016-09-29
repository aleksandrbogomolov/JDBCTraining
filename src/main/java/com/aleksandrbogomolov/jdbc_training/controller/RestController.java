package com.aleksandrbogomolov.jdbc_training.controller;

import com.aleksandrbogomolov.jdbc_training.entity.User;
import com.aleksandrbogomolov.jdbc_training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("user")
public class RestController {

    private final UserService userService;

    @Autowired
    public RestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getOne(@PathVariable("id") int id) {
        return userService.getOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody User user) {
        userService.save(user);
    }
}
