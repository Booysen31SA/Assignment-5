package com.Booysen31SA.factory.teacher.demography;

import com.Booysen31SA.domain.teacher.demography.Race;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RaceFactoryTest {

    private Race race;
    @Before
    public void setUp() throws Exception {
        race = RaceFactory.buildRace("Coloured");
    }

    @Test
    public void buildRace() {
        assertNotNull(race.getRaceId());
    }
}