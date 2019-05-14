package com.Booysen31SA.services.impl.retirement.putRequest;

import com.Booysen31SA.domain.retirement.PutRequest;
import com.Booysen31SA.factory.putRequestFactory.PutRequestFactory;
import com.Booysen31SA.repository.impl.retirement.putRequest.PutRequestRepository;
import com.Booysen31SA.repository.impl.retirement.putRequest.PutRequestRepositoryImpl;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PutRequestServiceImplTest {

    private PutRequestRepository repository;
    private PutRequest getClass;

    private PutRequest getSaved(){return this.repository.getAll().iterator().next();}

    @Before
    public void setUp() throws Exception {
        this.repository = PutRequestRepositoryImpl.getPutRequest();
        this.getClass =  PutRequestFactory.requestAdd(216062241, com.Booysen31SA.util.Misc.generateId() , "Matthew", "Booysen", 5000.0);

    }

    @Test
    public void getAll() {
    }

    @Test
    public void create() {
        PutRequest created = this.repository.create(this.getClass);
        System.out.println("Created : "+created);
        assertNotNull(created);
        assertSame(created, this.getClass);
    }

    @Test
    public void update() {
        PutRequest app = this.repository.create(this.getClass);

        repository.create(app);

        PutRequest updateapp = PutRequestFactory.requestAdd(216062241, com.Booysen31SA.util.Misc.generateId() , "Matthew", "Booysen", 6000.0);


        repository.update(updateapp);
        assertEquals(updateapp, repository.read(216062241));
        System.out.println(repository.getAll());
    }

    @Test
    public void delete() {
        PutRequest app = this.repository.create(this.getClass);

        repository.create(app);

        //appointment.delete(216062241);
        //assertNull(appointment.read(216062241));
        System.out.println(repository.getAll());
    }

    @Test
    public void read() {
        PutRequest app =this.repository.create(this.getClass);

        repository.create(app);
        assertNotNull(repository.read(216062241));
        System.out.println(repository.getAll());
    }
}