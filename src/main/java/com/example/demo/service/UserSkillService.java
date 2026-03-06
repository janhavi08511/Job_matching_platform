package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.UserSkillRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserSkillService {

    private final UserSkillRepository userSkillRepository;

    public UserSkillService(UserSkillRepository userSkillRepository) {
        this.userSkillRepository = userSkillRepository;
    }

    public void saveUserSkills(UserEntity user, Set<SkillEntity> skills, String source) {

        for (SkillEntity skill : skills) {

            UserSkillEntity userSkill = new UserSkillEntity();
            userSkill.setUser(user);
            userSkill.setSkill(skill);
            userSkill.setSource(source);
            userSkill.setProficiency(null); // will be updated later

            userSkillRepository.save(userSkill);
        }
    }
}
