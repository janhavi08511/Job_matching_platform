package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserSkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserSkillRepository extends JpaRepository<UserSkillEntity, Long > {
    List<UserSkillEntity> findByUser(UserEntity user);
}
