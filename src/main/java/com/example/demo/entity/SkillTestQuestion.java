package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "skill_questions")
public class SkillTestQuestion {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skill;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String correctAnswer;

    // getters & setters
}

