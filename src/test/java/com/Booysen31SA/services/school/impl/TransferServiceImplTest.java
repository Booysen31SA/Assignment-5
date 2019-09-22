package com.Booysen31SA.services.school.impl;

import com.Booysen31SA.domain.school.Transfer;
import com.Booysen31SA.factory.school.TransferFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransferServiceImplTest {

    private Transfer transfer;
    private TransferServiceImpl service;

    @Before
    public void setUp() throws Exception {
        service = TransferServiceImpl.getService();
    }
    @Test
    public void getTransferService() {
        service = TransferServiceImpl.getService();
    }

    @Test
    public void create() {
        transfer = TransferFactory.buildTransfer("216062241", "sdvsdvvsvd", "dvvvvsdvsd", 555454);
        service.create(transfer);
        assertNotNull(service.read(transfer.getPersalNumber()));
    }

    @Test
    public void read() {
        transfer = TransferFactory.buildTransfer("216062241", "sdvsdvvsvd", "dvvvvsdvsd", 555454);
        service.create(transfer);
        assertNotNull(service.read(transfer.getPersalNumber()));
    }

    @Test
    public void update() {
        transfer = TransferFactory.buildTransfer("216062241", "sdvsdvvsvd", "dvvvvsdvsd", 555454);
        Transfer Updated = TransferFactory.buildTransfer("216062241", "sdvsdvvsvd", "dvvvvsdvsd", 800000);
        service.create(transfer);
        service.update(Updated);

        Transfer d = service.read(transfer.getPersalNumber());
        assertNotSame(transfer.getTeacherAmount(), d.getTeacherAmount());
    }

    @Test
    public void delete() {
        transfer = TransferFactory.buildTransfer("216062241", "sdvsdvvsvd", "dvvvvsdvsd", 555454);
        service.create(transfer);
        service.delete(transfer.getPersalNumber());
        assertNull(service.read(transfer.getPersalNumber()));
    }

    @Test
    public void getAll() {
        transfer = TransferFactory.buildTransfer("216062241", "sdvsdvvsvd", "dvvvvsdvsd", 555454);
        service.create(transfer);
        assertNotNull(service.getAll());
    }
}