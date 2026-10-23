package com.gardenshow.greenhouse.plantShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gardenshow.greenhouse.plantShow.entity.Plant;

public interface PlantsRepository extends JpaRepository<Plant, Integer> {
}
