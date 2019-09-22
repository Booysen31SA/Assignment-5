package com.Booysen31SA.factory.retirement;

import com.Booysen31SA.domain.retirement.Retirement;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RetirementFactoryTest {

    private Retirement retirement;
    @Before
    public void setUp() throws Exception {
        retirement = RetirementFactory.buildRetirement("216062241"
                                                               , 97021873430L
                                                               , "Matthew"
                                                               , "Booysen"
                                                               , 17500);
    }

    @Test
    public void buildRetirement() {
        assertNotNull(retirement);
    }
}