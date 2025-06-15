package com.example.UrbanClone.controller;

import com.example.UrbanClone.dto.LoginRequest;
import com.example.UrbanClone.dto.RegisterRequest;
import com.example.UrbanClone.entity.User;
import com.example.UrbanClone.security.JwtUtil;
import com.example.UrbanClone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest req) {
        User u = userService.register(req);
        return "User registered: " + u.getEmail();

    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest req) {
        User u = userService.login(req);
        if (u == null) return "Invalid credentials";
        return jwtUtil.generateToken(u.getEmail());
    }

}


