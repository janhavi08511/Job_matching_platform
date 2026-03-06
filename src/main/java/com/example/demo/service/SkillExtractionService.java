package com.example.demo.service;

import com.example.demo.entity.SkillEntity;
import com.example.demo.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SkillExtractionService {

    private final SkillRepository skillRepository;

    public SkillExtractionService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Set<String> extractSkills(String resumeText) {

        Set<String> extractedSkills = new HashSet<>();
        String lowerText = resumeText.toLowerCase();

        // 1️⃣ Fetch skills from DB
        List<SkillEntity> skillsFromDb = skillRepository.findAll();

        // 2️⃣ Match skills
        for (SkillEntity skill : skillsFromDb) {
            if (lowerText.contains(skill.getSkillName().toLowerCase())) {
                extractedSkills.add(skill.getSkillName());
            }
        }

        return extractedSkills;
    }
}
