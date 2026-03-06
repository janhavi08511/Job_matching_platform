package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.MLUserJobDatasetRepository;
import java.util.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;

@Service
public class MLFeatureEngineeringService {

    private final UserRepository userRepository;
    private final UserSkillRepository userSkillRepository;
    private final ResumeScoreRepository resumeScoreRepository;
    private final MLUserJobDatasetRepository mlRepo;

    public MLFeatureEngineeringService(
            UserRepository userRepository,
            UserSkillRepository userSkillRepository,
            ResumeScoreRepository resumeScoreRepository,
            MLUserJobDatasetRepository mlRepo) {

        this.userRepository = userRepository;
        this.userSkillRepository = userSkillRepository;
        this.resumeScoreRepository = resumeScoreRepository;
        this.mlRepo = mlRepo;
    }

    public void buildDatasetForUser(Long userId) {

        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<UserSkillEntity> skills =
                userSkillRepository.findByUser(user);

        int totalScore = 0;
        int skillCount = 0;

        for (UserSkillEntity us : skills) {
            totalScore += us.getProficiency();
            skillCount++;
        }

        int avgSkillScore = skillCount > 0 ? totalScore / skillCount : 0;

        ResumeScoreEntity resumeScore =
                resumeScoreRepository.findByUser(user);

        MLUserJobDatasetEntity row = new MLUserJobDatasetEntity();

        row.setUserId(user.getUserId());
        row.setExperienceYears(user.getExperience());
        row.setAvgSkillScore(avgSkillScore);
        row.setTotalSkills(skillCount);
        row.setAtsScore(resumeScore.getAtsScore());

        row.setRecommendedRole(predictRole(avgSkillScore));
        row.setJobMatchPercentage(avgSkillScore);
        row.setSelectionOutcome(avgSkillScore >= 70);

        mlRepo.save(row);
    }

    private String predictRole(int avgSkillScore) {

        if(avgSkillScore >= 80)
            return "Backend Developer";

        if(avgSkillScore >= 60)
            return "Junior Developer";

        return "Trainee";
    }
}
