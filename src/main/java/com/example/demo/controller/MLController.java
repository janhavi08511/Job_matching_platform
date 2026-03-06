package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

    @RestController
    @RequestMapping("/api/ml")
    public class MLController {

        @GetMapping("/predict/{userId}")
        public Map<String,Object> predict(){

            return Map.of(
                    "role","Backend Developer",
                    "confidence",82
            );
        }
    }

