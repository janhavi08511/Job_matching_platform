package com.example.demo.entity;

import jakarta.persistence.*;
@Entity
public class ResumeScoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private int atsScore;

    public Integer getAtsScore() {

        return atsScore;
    }
}