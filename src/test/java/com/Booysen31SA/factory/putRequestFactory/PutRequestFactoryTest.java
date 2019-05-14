package com.Booysen31SA.factory.putRequestFactory;

import com.Booysen31SA.domain.retirement.PutRequest;
import com.Booysen31SA.util.Misc;
import org.junit.Test;
import static org.junit.Assert.*;

public class PutRequestFactoryTest {

    @Test
    public void requestAdd() {

        PutRequest putReq = PutRequestFactory.requestAdd(216062241,
                 Misc.generateId(),
                "Matthew",
                "Booysen",
                45000.2);

        assertNotNull(putReq);
        System.out.println(putReq);
    }
}