package com.Booysen31SA.factory.teacher.demography;

import com.Booysen31SA.domain.teacher.demography.Gender;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenderFactoryTest {
    private Gender gender;

    @Before
    public void setUp() throws Exception {
        gender = GenderFactory.buildGender("Male");
    }

    @Test
    public void buildGender() {
        assertNotNull(gender.getGenderId());
    }
}