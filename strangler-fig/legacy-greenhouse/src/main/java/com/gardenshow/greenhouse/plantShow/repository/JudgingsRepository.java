package com.gardenshow.greenhouse.plantShow.repository;

import com.gardenshow.greenhouse.plantShow.entity.Judging;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JudgingsRepository extends JpaRepository<Judging, String> {
}
