package com.Booysen31SA.factory.teacher.demography;
import com.Booysen31SA.domain.teacher.demography.Gender;
import com.Booysen31SA.util.Helper;

public class GenderFactory {

    private static final String SUFFIX = Helper.getSuffixFromClassName(GenderFactory.class); // Expecting GF from (G)ender(F)actory.

    public static Gender buildGender(String genderDescription) {
        return new Gender.Builder()
                .genderId(Helper.generateRandomGivenSuffix(SUFFIX))
                .genderDescription(genderDescription)
                .build();
    }
}
