package com.Booysen31SA.domain.teacher;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DemographicsTest {
    private Demographics demo;

    @Before
    public void setUp() {
        demo = new Demographics("Male", "Coloured");

    }

    @Test
    public void demoTest() {
        assertEquals("Male", demo.getGender());
    }
}