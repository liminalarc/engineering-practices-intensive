package com.gardenshow.greenhouse.plantShow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.Instant;
import java.util.UUID;

@Entity
public class Judging {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Entry winner;

    @ManyToOne
    @JoinColumn(name = "runner_up_id")
    private Entry runnerUp;

    private Instant judgedAt;

    protected Judging() {
    }

    public Judging(Entry winner, Entry runnerUp) {
        this.id = UUID.randomUUID().toString();
        this.winner = winner;
        this.runnerUp = runnerUp;
        this.judgedAt = Instant.now();
    }

    public String getId() {
        return id;
    }

    public Entry getWinner() {
        return winner;
    }

    public Entry getRunnerUp() {
        return runnerUp;
    }

    public Instant getJudgedAt() {
        return judgedAt;
    }
}
