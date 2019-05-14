package com.Booysen31SA.services.impl.retirement.finalizeRequest;

import com.Booysen31SA.domain.retirement.FinalizeRequest;
import com.Booysen31SA.factory.finalizeRequest.FinalizeRequestFactory;
import com.Booysen31SA.repository.impl.retirement.finailzeRequest.FinalizeRequestRepository;
import com.Booysen31SA.repository.impl.retirement.finailzeRequest.FinalizeRequestRepositoryImpl;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FinalizeRequestServiceImplTest {

    private FinalizeRequestRepository repository;
    private FinalizeRequest getClass;

    private FinalizeRequest getSaved(){return this.repository.getAll().iterator().next();}

    @Before
    public void setUp() throws Exception {
        this.repository = FinalizeRequestRepositoryImpl.getFinalizeRequest();
        this.getClass =  FinalizeRequestFactory.Update(216062241, com.Booysen31SA.util.Misc.generateId(), 50000.0, "Waiting");

    }

    @Test
    public void getAll() {
    }

    @Test
    public void create() {
        FinalizeRequest created = this.repository.create(this.getClass);
        System.out.println("Created : "+created);
        assertNotNull(created);
        assertSame(created, this.getClass);
    }

    @Test
    public void update() {
        FinalizeRequest app = this.repository.create(this.getClass);

        repository.create(app);

        FinalizeRequest updateapp = FinalizeRequestFactory.Update(216062241, com.Booysen31SA.util.Misc.generateId(), 50000.0, "Approved");


        repository.update(updateapp);
        assertEquals(updateapp, repository.read(216062241));
        System.out.println(repository.getAll());
    }

    @Test
    public void delete() {
        FinalizeRequest app = this.repository.create(this.getClass);

        repository.create(app);

        //appointment.delete(216062241);
        //assertNull(appointment.read(216062241));
        System.out.println(repository.getAll());
    }

    @Test
    public void read() {
        FinalizeRequest app =this.repository.create(this.getClass);

        repository.create(app);
        assertNotNull(repository.read(216062241));
        System.out.println(repository.getAll());
    }
}