package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class JobService {

    public List<Map<String,Object>> recommendJobs(){

        List<Map<String,Object>> jobs = new ArrayList<>();

        jobs.add(Map.of(
                "title","Backend Developer",
                "company","TechCorp",
                "match",87
        ));

        jobs.add(Map.of(
                "title","Java Developer",
                "company","Infosys",
                "match",82
        ));

        jobs.add(Map.of(
                "title","Software Engineer",
                "company","TCS",
                "match",78
        ));

        return jobs;
    }
}