package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String home(){
        return "welcome to home";
    }

    @PostMapping("/register")
    public String register(@RequestBody  User user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody  User user){
        return userService.login(user);
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "welcome to dashboard";
    }

}
