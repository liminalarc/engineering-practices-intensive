package com.gardenshow.greenhouse.plantShow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

@Entity
public class Entry {
    @Id
    private String id;
    private String species;
    private int bloom;
    private int form;
    private int vigor;
    private String status;
    private int ribbons;
    private int runnerUps;

    @ManyToOne
    @JoinColumn(name = "plant_id")
    private Plant plant;

    protected Entry() {
    }

    public Entry(String species, int bloom, int form, int vigor, Plant plant) {
        this.id = UUID.randomUUID().toString();
        this.species = species;
        this.bloom = bloom;
        this.form = form;
        this.vigor = vigor;
        this.status = "COMPETING";
        this.plant = plant;
    }

    public void losePoints(int amount) {
        this.vigor = Math.max(0, this.vigor - amount);
        if (this.vigor == 0) {
            this.status = "ELIMINATED";
        }
    }

    public void awardRibbon() {
        this.ribbons++;
    }

    public void recordRunnerUp() {
        this.runnerUps++;
    }

    public String getId() {
        return id;
    }

    public String getSpecies() {
        return species;
    }

    public int getBloom() {
        return bloom;
    }

    public int getForm() {
        return form;
    }

    public int getVigor() {
        return vigor;
    }

    public String getStatus() {
        return status;
    }

    public int getRibbons() {
        return ribbons;
    }

    public int getRunnerUps() {
        return runnerUps;
    }

    public Plant getPlant() {
        return plant;
    }
}
