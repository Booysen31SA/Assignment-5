package com.Booysen31SA.factory.finalizeRequest;

import com.Booysen31SA.domain.retirement.FinalizeRequest;
import com.Booysen31SA.util.Misc;
import org.junit.Test;

import static org.junit.Assert.*;

public class FinalizeRequestFactoryTest {



    @Test
    public void requestUpdate() {

        FinalizeRequest finalReq = FinalizeRequestFactory.Update(216062241,
                                                                  Misc.generateId(),
                                                                 45000.2,
                                                                 "Approved");

        assertNotNull(finalReq);
        System.out.println(finalReq);
    }
}