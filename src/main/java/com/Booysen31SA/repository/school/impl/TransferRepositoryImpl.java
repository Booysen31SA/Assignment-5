//package com.Booysen31SA.repository.school.impl;
//
//import com.Booysen31SA.domain.school.Transfer;
//import com.Booysen31SA.repository.school.ITransfer;
//import org.springframework.stereotype.Repository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Repository("TransferInMemory")
//public class TransferRepositoryImpl implements ITransfer {
//    private Set<Transfer> transferDB;
//    private static TransferRepositoryImpl TransferRepository = null;
//
//    private TransferRepositoryImpl() {
//        this.transferDB = new HashSet<>();
//    }
//
//    public static TransferRepositoryImpl getTransferRepository() {
//        if (TransferRepository == null) TransferRepository = new TransferRepositoryImpl();
//        return TransferRepository;
//    }
//    @Override
//    public Transfer create(Transfer transfer) {
//        if(read(transfer.getPersalNumber()) == null){
//            transferDB.add(transfer);
//        }
//        return transfer;
//    }
//
//    @Override
//    public Transfer read(String s) {
//        return transferDB.stream().filter(transfer -> transfer.getPersalNumber().equalsIgnoreCase(s)).findAny().orElse(null);
//
//    }
//
//    @Override
//    public Transfer update(Transfer transfer) {
//        if(read(transfer.getPersalNumber()) != null){
//            delete(transfer.getPersalNumber());
//            create(transfer);
//        }
//        return transfer;
//    }
//
//    @Override
//    public void delete(String s) {
//        Transfer appointment = read(s);
//        if(appointment != null){
//            transferDB.remove(appointment);
//        }
//    }
//
//    @Override
//    public Set<Transfer> getAll() {
//        return transferDB;
//    }
//}
