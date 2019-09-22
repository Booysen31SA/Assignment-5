package com.Booysen31SA.factory.teacher.demography;
import com.Booysen31SA.domain.teacher.demography.Race;
import com.Booysen31SA.util.Helper;

public class RaceFactory {

    private static final String SUFFIX = Helper.getSuffixFromClassName(RaceFactory.class); // Expecting RF from (R)ace(F)actory.

    public static Race buildRace(String raceDescription) {
       return new Race.Builder()
               .raceId(Helper.generateRandomGivenSuffix(SUFFIX))
               .raceDescription(raceDescription)
               .build();
    }
}
