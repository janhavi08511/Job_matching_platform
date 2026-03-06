
package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "ml_user_job_dataset")
public class MLUserJobDatasetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Integer experienceYears;
    private Integer avgSkillScore;
    private Integer atsScore;
    private Integer totalSkills;

    private String recommendedRole;
    private Integer jobMatchPercentage;
    private Boolean selectionOutcome;

    private LocalDateTime createdAt = LocalDateTime.now();

    public void setUserId(Long userId) {
    }

    // getters and setters
}
