package com.Booysen31SA.factory.school;

import com.Booysen31SA.domain.school.Status;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StatusFactoryTest {
       private Status status;
    @Before
    public void setUp() throws Exception {
        status = StatusFactory.buildStatus("216062241", "ascsacaccasc");
    }

    @Test
    public void buildStatus() {
        assertNotNull(status);
    }
}