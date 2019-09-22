package com.Booysen31SA.services.school.impl;

import com.Booysen31SA.domain.school.Transfer;
import com.Booysen31SA.repository.school.impl.TransferRepositoryImpl;
import com.Booysen31SA.services.school.ITransfer;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("TransferServiceImpl")
public class TransferServiceImpl implements ITransfer {


    private static TransferServiceImpl service = null;
    private TransferRepositoryImpl repository;
    
    public TransferServiceImpl(){
        repository = TransferRepositoryImpl.getTransferRepository();
    }
    public static TransferServiceImpl getService(){
        if(service == null){
            return new TransferServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Transfer> getAll() {
        return repository.getAll();
    }

    @Override
    public Transfer create(Transfer appointment) {
        return repository.create(appointment);
    }

    @Override
    public Transfer read(String integer) {
        return repository.read(integer);
    }

    @Override
    public Transfer update(Transfer appointment) {
        return repository.update(appointment);
    }

    @Override
    public void delete(String integer) {
        repository.delete(integer);
    }
}
