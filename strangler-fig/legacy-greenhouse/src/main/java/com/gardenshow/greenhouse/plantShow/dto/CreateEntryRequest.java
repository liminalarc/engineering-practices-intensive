package com.gardenshow.greenhouse.plantShow.dto;

public record CreateEntryRequest(String species, int bloom, int form, int vigor, Integer plantId) {
}
