package com.Booysen31SA.factory.teacher.user;

import com.Booysen31SA.domain.teacher.user.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserFactoryTest {

    private User user;
    @Before
    public void setUp() throws Exception {
        user = UserFactory.buildUser("216062241"
        ,"51515415458L", "Matthew"
        ,"Booysen");
    }

    @Test
    public void buildUser() {
        assertNotNull(user);
    }
}