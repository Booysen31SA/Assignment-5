package com.Booysen31SA.repository.impl.retirement.finailzeRequest;

import com.Booysen31SA.domain.retirement.FinalizeRequest;
import com.Booysen31SA.factory.finalizeRequest.FinalizeRequestFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FinalizeRequestRepositoryImplTest {

    FinalizeRequestRepositoryImpl finalize;

    @Before
    public void setUp() {
        finalize = FinalizeRequestRepositoryImpl.getFinalizeRequest();
    }

    @Test
    public void getAll() {
    }

    @Test
    public void create() {
        FinalizeRequest finalR = FinalizeRequestFactory.Update(216062245, com.Booysen31SA.util.Misc.generateId(), 50000.0, "Approved");

        finalize.create(finalR);
        assertNotNull(finalize.getAll());
        System.out.println(finalize.getAll());
    }

    @Test
    public void update() {
        FinalizeRequest finalR = FinalizeRequestFactory.Update(216062241, com.Booysen31SA.util.Misc.generateId(), 50000.0, "Declined");

        finalize.create(finalR);
        FinalizeRequest updatefinalR = FinalizeRequestFactory.Update(216062241, com.Booysen31SA.util.Misc.generateId(), 4000.0, "Approved");
        finalize.update(updatefinalR);
        assertEquals(updatefinalR, finalize.read(216062241));
        System.out.println(finalize.getAll());
    }

    @Test
    public void delete() {
        FinalizeRequest finalR = FinalizeRequestFactory.Update(216062241, com.Booysen31SA.util.Misc.generateId(), 50000.0, "Approved");

        finalize.create(finalR);
        System.out.println(finalize.getAll());
        finalize.delete(216062241);
        assertNull(finalize.read(216062241));
        System.out.println(finalize.getAll());
    }

    @Test
    public void read() {
    }
}