package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @DubboReference
    private UserService userService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getByUserId(@PathVariable("userId") Integer userId) {
        System.out.println("userId = " + userId);
        User user = userService.getByUserId(userId);
        System.out.println("user = " + user);
        return ResponseEntity.ok(userService.getByUserId(userId));
    }
}