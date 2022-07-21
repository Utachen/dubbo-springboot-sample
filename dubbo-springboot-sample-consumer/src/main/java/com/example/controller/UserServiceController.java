package com.example.controller;

import entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class UserServiceController {

    @RequestMapping("/user/{id}")
    User getUserInfo(@PathVariable("id") Long id) {
        return new User(2L,"consumer","consumer is here");
    }

}
