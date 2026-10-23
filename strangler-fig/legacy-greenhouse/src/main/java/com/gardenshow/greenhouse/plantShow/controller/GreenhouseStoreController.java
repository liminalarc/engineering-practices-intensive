package com.gardenshow.greenhouse.plantShow.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gardenshow.greenhouse.plantShow.dto.CreatePlantRequest;
import com.gardenshow.greenhouse.plantShow.entity.Plant;
import com.gardenshow.greenhouse.plantShow.repository.PlantsRepository;

@RestController
public class GreenhouseStoreController {
    private final PlantsRepository plants;

    public GreenhouseStoreController(PlantsRepository plants) {
        this.plants = plants;
    }

    @GetMapping("/store/plants/{id}")
    public ResponseEntity<Plant> getPlant(@PathVariable Integer id) {
        return plants.findById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/store/plants")
    public Plant createPlant(@RequestBody CreatePlantRequest request) {
        Plant plant = new Plant(request.species(), request.height(), request.width(), request.description());
        return plants.save(plant);
    }
    
}
