package com.Booysen31SA.util;
import com.Booysen31SA.factory.teacher.demography.GenderFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HelperTest {

    private static final String SUFFIX = Helper.getSuffixFromClassName(GenderFactory.class); // Expecting GF from (G)ender(F)actory.
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getSuffixFromClassName() {
        System.out.println("SUFFIX should be GF");
        assertEquals(SUFFIX, "GF");
    }

    @Test
    public void generateRandomGivenSuffix() {
    }

    @Test
    public void getClassName() {
    }

    @Test
    public void testGetSuffixFromClassName() {
    }
}