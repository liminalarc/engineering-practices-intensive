package com.gardenshow.greenhouse.plantShow.repository;

import com.gardenshow.greenhouse.plantShow.dto.EntrySummary;
import com.gardenshow.greenhouse.plantShow.entity.Entry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EntriesRepository extends JpaRepository<Entry, String> {

    @Query("SELECT new com.gardenshow.greenhouse.plantShow.dto.EntrySummary(m.id, m.species) FROM Entry m")
    List<EntrySummary> findAllSummaries();
}
