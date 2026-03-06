package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@Entity
@Table(
        name = "user_skills",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "skill_id"})
)
public class UserSkillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many skills belong to one user
    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity user;

    // Many users can have same skill
    @ManyToOne
    @JoinColumn(name = "skill_id", nullable = false)
    private SkillEntity skill;

    private String source;       // resume / test
    private Integer proficiency; // null for now



    // getters & setters
}
