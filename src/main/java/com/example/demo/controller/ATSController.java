package com.example.demo.controller;

import com.example.demo.service.ATSService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ats")
public class ATSController {

    private final ATSService atsService;

    public ATSController(ATSService atsService) {
        this.atsService = atsService;
    }

    @GetMapping("/score/{userId}")
    public int getScore(@PathVariable Long userId){

        return atsService.calculateATSScore(userId);

    }
}