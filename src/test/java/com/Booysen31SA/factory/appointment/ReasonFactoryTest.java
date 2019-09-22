package com.Booysen31SA.factory.appointment;

import com.Booysen31SA.domain.appointment.Reason;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReasonFactoryTest {

    private Reason reason;
    @Before
    public void setUp() throws Exception {
        reason = ReasonFactory.buildReason("216062241", "abcdefghijklmnop");
    }

    @Test
    public void buildReason() {
        assertNotNull(reason);
    }
}