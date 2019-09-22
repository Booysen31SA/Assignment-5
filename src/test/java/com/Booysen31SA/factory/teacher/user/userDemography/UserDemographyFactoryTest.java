package com.Booysen31SA.factory.teacher.user.userDemography;

import com.Booysen31SA.domain.teacher.user.userDemography.UserDemography;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDemographyFactoryTest {

    private UserDemography userDemography;
    @Before
    public void setUp() throws Exception {
        userDemography = UserDemographyFactory.buildUserDemography("216062241","1", "1");
    }

    @Test
    public void buildUserDemography() {
        assertNotNull(userDemography);
    }
}