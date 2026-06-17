package com.shraddha.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shraddha.demo.model.PestDisease;

@Repository
public interface PestDiseaseRepository extends JpaRepository<PestDisease, Integer> {

}