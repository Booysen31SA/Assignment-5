package com.Booysen31SA.factory.teacher.user.appointed;

import com.Booysen31SA.domain.teacher.user.appointed.DateAppointed;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateAppointedFactoryTest {
    private DateAppointed dateAppointed;

    @Before
    public void setUp() throws Exception {
        dateAppointed = DateAppointedFactory.buildDateAppointed("216062241", "17/02/2020");
    }

    @Test
    public void buildDateAppointed() {
        assertNotNull(dateAppointed);
    }
}