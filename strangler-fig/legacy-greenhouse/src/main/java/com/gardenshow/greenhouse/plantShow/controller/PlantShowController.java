package com.gardenshow.greenhouse.plantShow.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gardenshow.greenhouse.plantShow.dto.JudgingRequest;
import com.gardenshow.greenhouse.plantShow.dto.JudgingResult;
import com.gardenshow.greenhouse.plantShow.dto.CreateEntryRequest;
import com.gardenshow.greenhouse.plantShow.entity.Judging;
import com.gardenshow.greenhouse.plantShow.entity.Entry;
import com.gardenshow.greenhouse.plantShow.entity.Plant;
import com.gardenshow.greenhouse.plantShow.repository.JudgingsRepository;
import com.gardenshow.greenhouse.plantShow.repository.EntriesRepository;
import com.gardenshow.greenhouse.plantShow.repository.PlantsRepository;
import com.gardenshow.greenhouse.plantShow.dto.EntrySummary;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class PlantShowController {
    private final EntriesRepository entries;
    private final JudgingsRepository judgings;
    private final PlantsRepository plants;

    public PlantShowController(EntriesRepository entries, JudgingsRepository judgings, PlantsRepository plants) {
        this.entries = entries;
        this.judgings = judgings;
        this.plants = plants;
    }

    @GetMapping("/show/entries/{id}")
    public ResponseEntity<Entry> getEntry(@PathVariable String id) {
        return entries.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/show/entries")
    public List<EntrySummary> listEntrySummaries() {
        return entries.findAllSummaries();
    }

    @PostMapping("/show/entries/judging")
    public ResponseEntity<JudgingResult> judge(@RequestBody JudgingRequest request) {
        try {
            String entryId = request.entryId();
            String rivalId = request.rivalId();
            Entry entry = entries.findById(entryId).orElseThrow(() -> new NoSuchElementException("No entry found with id " + entryId));
            Entry rival = entries.findById(rivalId).orElseThrow(() -> new NoSuchElementException("No entry found with id " + rivalId));

            while (!entry.getStatus().equals("ELIMINATED") && !rival.getStatus().equals("ELIMINATED")) {
                rival.losePoints(Math.max(1, entry.getBloom() - rival.getForm()));
                if (rival.getStatus().equals("ELIMINATED")) {
                    break;
                }
                entry.losePoints(Math.max(1, rival.getBloom() - entry.getForm()));
            }

            Entry winner = rival.getStatus().equals("ELIMINATED") ? entry : rival;
            Entry runnerUp = winner == entry ? rival : entry;
            winner.awardRibbon();
            runnerUp.recordRunnerUp();
            entries.save(winner);
            entries.save(runnerUp);
            judgings.save(new Judging(winner, runnerUp));

            return ResponseEntity.ok(new JudgingResult(winner, runnerUp));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/show/entries")
    public ResponseEntity<Entry> createEntry(@RequestBody CreateEntryRequest request) {
        try {
            Plant plant = plants.findById(request.plantId())
                    .orElseThrow(() -> new NoSuchElementException("No plant found with id " + request.plantId()));
            Entry newEntry = new Entry(request.species(), request.bloom(), request.form(), request.vigor(), plant);
            return ResponseEntity.ok(entries.save(newEntry));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
