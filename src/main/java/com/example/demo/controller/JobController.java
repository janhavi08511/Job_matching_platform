package com.example.demo.controller;

import com.example.demo.service.JobService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

    @RestController
    @RequestMapping("/api/jobs")
    public class JobController {

        private final JobService jobService;

        public JobController(JobService jobService) {
            this.jobService = jobService;
        }

        @GetMapping("/recommend")
        public List<Map<String,Object>> jobs(){

            return jobService.recommendJobs();

        }
    }

