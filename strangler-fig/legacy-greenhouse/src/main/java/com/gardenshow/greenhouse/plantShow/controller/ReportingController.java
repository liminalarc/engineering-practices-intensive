package com.gardenshow.greenhouse.plantShow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gardenshow.greenhouse.plantShow.dto.EntriesPerSpecies;
import com.gardenshow.greenhouse.plantShow.entity.Entry;
import com.gardenshow.greenhouse.plantShow.entity.Plant;
import com.gardenshow.greenhouse.plantShow.repository.EntriesRepository;
import com.gardenshow.greenhouse.plantShow.repository.PlantsRepository;
import java.util.Comparator;
import java.util.List;

@RestController
public class ReportingController {
    private final PlantsRepository plants;
    private final EntriesRepository entries;

    public ReportingController(PlantsRepository plants, EntriesRepository entries) {
        this.entries = entries;
        this.plants = plants;
    }
    
    @GetMapping("/reporting/standings")
    public List<Entry> standings() {
        return entries.findAll().stream()
                .sorted(Comparator.comparingInt(Entry::getRibbons).reversed())
                .toList();
    }

    @GetMapping("/reporting/best-in-show")
    public Entry bestInShow() {
        return entries.findAll().stream()
                .sorted(Comparator.comparingInt(Entry::getRibbons).reversed())
                .toList().get(0);
    }

    @GetMapping("/reporting/tallest")
    public Plant tallestPlant() {
        return plants.findAll().stream()
                .sorted(Comparator.comparingInt(Plant::getHeight).reversed())
                .toList().get(0);
    }

    @GetMapping("/reporting/entries-per-species")
    public List<EntriesPerSpecies> entriesPerSpecies() {
        List<Entry> allEntries = entries.findAll();
        return plants.findAll().stream()
                .map(plant -> {
                    List<String> entryNames = allEntries.stream()
                            .filter(entry -> entry.getPlant() != null && entry.getPlant().getId().equals(plant.getId()))
                            .map(Entry::getSpecies)
                            .toList();
                    return new EntriesPerSpecies(plant.getSpecies(), entryNames.size(), entryNames);
                })
                .toList();
    }
}
