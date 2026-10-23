package com.gardenshow.greenhouse.plantShow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String species;
    private int height;
    private int width;
    private String description;


    protected Plant() {
    }

    public Plant(String species, int height, int width, String description) {
        this.species = species;
        this.height = height;
        this.width = width;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getSpecies() {
        return species;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getDescription() {
        return description;
    }
}
