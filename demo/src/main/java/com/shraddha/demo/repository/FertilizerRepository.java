package com.shraddha.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shraddha.demo.model.Fertilizer;

@Repository
public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {

    List<Fertilizer> findByCropName(String cropName);

    List<Fertilizer> findByCropNameAndSoilType(String cropName, String soilType);

}