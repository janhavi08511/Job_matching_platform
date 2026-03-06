package com.example.demo.controller;

import com.example.demo.dto.LoginRequestDTO;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.SignupRequestDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequestDTO dto) {
        UserEntity user = userService.registerUser(dto);
        return ResponseEntity.ok("User registered successfully");
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO dto) {
        userService.login(dto);
        return ResponseEntity.ok("Login successful");
    }

}
