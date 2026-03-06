package com.example.demo.service;

import com.example.demo.entity.ResumeEntity;
import com.example.demo.entity.SkillEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.ResumeRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.repository.SkillRepository;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ResumeService {

    private final UserSkillService userSkillService;
    private final ResumeRepository resumeRepository;
    private final UserRepository userRepository;
    private final SkillRepository skillRepository;
    private final ResumeParsingService resumeParsingService;
    private final SkillExtractionService skillExtractionService;

    public ResumeService(
            UserSkillService userSkillService,
            ResumeRepository resumeRepository,
            UserRepository userRepository,
            SkillRepository skillRepository,
            ResumeParsingService resumeParsingService,
            SkillExtractionService skillExtractionService
    ) {
        this.userSkillService = userSkillService;
        this.resumeRepository = resumeRepository;
        this.userRepository = userRepository;
        this.skillRepository = skillRepository;
        this.resumeParsingService = resumeParsingService;
        this.skillExtractionService = skillExtractionService;
    }

    public void uploadResume(MultipartFile file, Long userId) {

        try {
            // 1️⃣ Fetch user
            UserEntity user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // 2️⃣ Save resume
            ResumeEntity resume = new ResumeEntity();
            resume.setFileName(file.getOriginalFilename());
            resume.setFileType(file.getContentType());
            resume.setData(file.getBytes());
            resume.setUser(user);

            resumeRepository.save(resume);

            // 3️⃣ Parse resume → text
            String resumeText = resumeParsingService.extractTextFromDocx(file);

            // 4️⃣ Extract skill NAMES (String)
            Set<String> extractedSkillNames =
                    skillExtractionService.extractSkills(resumeText);

            // 5️⃣ Convert skill names → SkillEntity
            List<SkillEntity> allSkills = skillRepository.findAll();

            Set<SkillEntity> matchedSkillEntities = allSkills.stream()
                    .filter(skill ->
                            extractedSkillNames.contains(skill.getSkillName()))
                    .collect(Collectors.toSet());

            // 6️⃣ Save user_skills
            userSkillService.saveUserSkills(
                    user,
                    matchedSkillEntities,
                    "resume"
            );

        } catch (Exception e) {
            throw new RuntimeException("Resume upload failed", e);
        }
    }
}
