package com.shraddha.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shraddha.demo.model.Crop;

public interface CropRepository extends JpaRepository<Crop, Long> {
}