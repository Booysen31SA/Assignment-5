//package com.Booysen31SA.repository.school.impl;
//
//import com.Booysen31SA.domain.school.Transfer;
//import com.Booysen31SA.factory.school.TransferFactory;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class TransferRepositoryImplTest {
//
//    private Transfer transfer;
//    private TransferRepositoryImpl repository;
//
//    @Before
//    public void setUp() throws Exception {
//        repository = TransferRepositoryImpl.getTransferRepository();
//    }
//    @Test
//    public void getTransferRepository() {
//        repository = TransferRepositoryImpl.getTransferRepository();
//    }
//
//    @Test
//    public void create() {
//        transfer = TransferFactory.buildTransfer("216062241", "sdvsdvvsvd", "dvvvvsdvsd", 555454);
//        repository.create(transfer);
//        System.out.println(repository.read(transfer.getPersalNumber()));
//        assertNotNull(repository.read(transfer.getPersalNumber()));
//    }
//
//    @Test
//    public void read() {
//        transfer = TransferFactory.buildTransfer("216062241", "sdvsdvvsvd", "dvvvvsdvsd", 555454);
//        repository.create(transfer);
//        assertNotNull(repository.read(transfer.getPersalNumber()));
//    }
//
//    @Test
//    public void update() {
//        transfer = TransferFactory.buildTransfer("216062241", "sdvsdvvsvd", "dvvvvsdvsd", 555454);
//        Transfer Updated = TransferFactory.buildTransfer("216062241", "sdvsdvvsvd", "dvvvvsdvsd", 800000);
//        repository.create(transfer);
//        repository.update(Updated);
//
//        Transfer d = repository.read(transfer.getPersalNumber());
//        assertNotSame(transfer.getTeacherAmount(), d.getTeacherAmount());
//    }
//
//    @Test
//    public void delete() {
//        transfer = TransferFactory.buildTransfer("216062241", "sdvsdvvsvd", "dvvvvsdvsd", 555454);
//        repository.create(transfer);
//        repository.delete(transfer.getPersalNumber());
//        assertNull(repository.read(transfer.getPersalNumber()));
//    }
//
//    @Test
//    public void getAll() {
//        transfer = TransferFactory.buildTransfer("216062241", "sdvsdvvsvd", "dvvvvsdvsd", 555454);
//        repository.create(transfer);
//        assertNotNull(repository.getAll());
//    }
//}