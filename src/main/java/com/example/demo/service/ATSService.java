package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class ATSService {

    public int calculateATSScore(Long userId){

        Random random = new Random();

        int keywordMatch = 60 + random.nextInt(30);
        int formatting = 65 + random.nextInt(25);
        int experience = 60 + random.nextInt(30);

        int atsScore = (keywordMatch + formatting + experience) / 3;

        return atsScore;
    }
}