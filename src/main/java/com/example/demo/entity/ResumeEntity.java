package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Setter;

@Setter
@Entity
@Table(name = "resumes")
public class ResumeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resumeId;

    private String FileName;

    private String FileType;

    @Lob
    private byte[] Data;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity User;

    // getters & setters
}
