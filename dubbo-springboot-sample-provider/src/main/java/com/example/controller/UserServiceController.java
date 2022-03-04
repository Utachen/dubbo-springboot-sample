package com.example.controller;

import entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserDubboService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/provider")
public class UserServiceController {

    @Resource
    UserDubboService userDubboService;

    @RequestMapping("/user/{id}")
    User getUserInfo(@PathVariable("id") Long id) {
        return userDubboService.getUserInfo(id);
    }
}
