package com.gardenshow.greenhouse.plantShow.dto;

import com.gardenshow.greenhouse.plantShow.entity.Entry;

public record JudgingResult(Entry winner, Entry runnerUp) {
}
