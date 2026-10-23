package com.liminalarc.wolverine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

class SpidermanTests {

    @Test
    void constructor_DefaultValues_SetsExpectedProperties() {
        var spider = new Spiderman();

        assertEquals("Peter Parker", spider.getName());
        assertEquals(100, spider.getEnergy());
        assertEquals(100, spider.getWebFluid());
        assertEquals(16, spider.getAge());
    }

    @Test
    void constructor_CustomValues_SetsExpectedProperties() {
        var spider = new Spiderman(80, 60,"Miles Morales", 32);

        assertEquals("Miles Morales", spider.getName());
        assertEquals(80, spider.getEnergy());
        assertEquals(60, spider.getWebFluid());
    }

    @Test
    void hasEnergyLeft_AfterTotalLoss_ReturnsFalse() {
        var spider = new Spiderman(10, 100,"Peter Parker", 17);
        spider.loseEnergy(10);
        assertFalse(spider.hasEnergyLeft());
    }

    @Test
    void shootWeb_DecreasesWebFluid() {
        var spider = new Spiderman(100, 50,"Peter Parker", 32);
        spider.shootWeb();
        assertEquals(38, spider.getWebFluid());
    }

    @Test
    void loseEnergy_ReducesEnergy() {
        var spider = new Spiderman(100, 100,"Peter Parker", 55);
        spider.loseEnergy(30);
        assertEquals(70, spider.getEnergy());
    }
}
