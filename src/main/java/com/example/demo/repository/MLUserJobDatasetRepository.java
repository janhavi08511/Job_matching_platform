package com.example.demo.repository;

import com.example.demo.entity.MLUserJobDatasetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MLUserJobDatasetRepository
        extends JpaRepository<MLUserJobDatasetEntity, Long> {
}