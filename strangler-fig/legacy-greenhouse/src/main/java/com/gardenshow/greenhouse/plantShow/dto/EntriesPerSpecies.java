package com.gardenshow.greenhouse.plantShow.dto;

import java.util.List;

public record EntriesPerSpecies(String species, int entryCount, List<String> entryNames) {
}
