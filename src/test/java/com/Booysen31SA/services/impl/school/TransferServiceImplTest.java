package com.Booysen31SA.services.impl.school;

import com.Booysen31SA.domain.school.School;
import com.Booysen31SA.domain.school.Transfer;
import com.Booysen31SA.factory.transferFactory.TransferFactory;
import com.Booysen31SA.repository.impl.school.TransferRepositoryImpl;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TransferServiceImplTest {

    private TransferRepositoryImpl repository;
    private Transfer getClass;

    private School getSaved(){return this.repository.getAll().iterator().next();}

    @Before
    public void setUp() throws Exception {
        this.repository = TransferRepositoryImpl.getTransfer();
        this.getClass = TransferFactory.TransferSchool(216062241, "Plumstead", "South Peninusla", 30000, "Approved");

    }

    @Test
    public void getAll() {
    }

    @Test
    public void create() {
        Transfer created = this.repository.create(this.getClass);
        System.out.println("Created : "+created);
        assertNotNull(created);
        assertSame(created, this.getClass);
    }

    @Test
    public void update() {
        Transfer app = this.repository.create(this.getClass);

        repository.create(app);

        Transfer updateapp = TransferFactory.TransferSchool(216062241, "Plumstead", "South Peninusla", 40000, "Approved");



        repository.update(updateapp);
        assertEquals(updateapp, repository.read(216062241));
        System.out.println(repository.getAll());
    }

    @Test
    public void delete() {
        Transfer app = this.repository.create(this.getClass);

        repository.create(app);

        //appointment.delete(216062241);
        //assertNull(appointment.read(216062241));
        System.out.println(repository.getAll());
    }

    @Test
    public void read() {
        Transfer app =this.repository.create(this.getClass);

        repository.create(app);
        assertNotNull(repository.read(216062241));
        System.out.println(repository.getAll());
    }
}