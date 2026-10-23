package com.gardenshow.greenhouse.plantShow.dto;

public record CreatePlantRequest(String species, int height, int width, String description) {
}
