package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user){ // ✅ For HTML forms
        userService.register(new User(user.getEmail(), user.getPassword(),user.getRole()));
        return "redirect:/login";
    }



    @GetMapping("/dashboard")
    public String dashBoard(HttpSession session, Model model) {
        Object user = session.getAttribute("SPRING_SECURITY_CONTEXT");
        model.addAttribute("sessionUser", user);
        return "dashboard";
    }

}
