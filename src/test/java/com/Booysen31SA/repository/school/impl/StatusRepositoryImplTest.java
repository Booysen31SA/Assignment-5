package com.Booysen31SA.repository.school.impl;

import com.Booysen31SA.domain.school.Status;
import com.Booysen31SA.factory.school.StatusFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StatusRepositoryImplTest {

    private Status status;
    private StatusRepositoryImpl repository;

    @Before
    public void setUp() throws Exception {
        repository = StatusRepositoryImpl.getStatusRepository();
    }
    @Test
    public void getStatusRepository() {
        repository = StatusRepositoryImpl.getStatusRepository();
    }

    @Test
    public void create() {
        status = StatusFactory.buildStatus("216062241", "Declined");
        repository.create(status);
        assertNotNull(repository.read(status.getPersal_Number()));
    }

    @Test
    public void read() {
        status = StatusFactory.buildStatus("216062241", "Declined");
        repository.create(status);
        assertNotNull(repository.read(status.getPersal_Number()));
    }

    @Test
    public void update() {
        status = StatusFactory.buildStatus("216062241", "Declined");
        Status Updated = StatusFactory.buildStatus("216062241", "Approved");
        repository.create(status);
        repository.update(Updated);

        Status d = repository.read(status.getPersal_Number());
        assertNotSame(status.getStatusRequest(), d.getStatusRequest());
    }

    @Test
    public void delete() {
        status = StatusFactory.buildStatus("216062241", "Declined");
        repository.create(status);
        repository.delete(status.getPersal_Number());
        assertNull(repository.read(status.getPersal_Number()));
    }

    @Test
    public void getAll() {
        status = StatusFactory.buildStatus("216062241", "Declined");
        repository.create(status);
        assertNotNull(repository.getAll());
    }
}