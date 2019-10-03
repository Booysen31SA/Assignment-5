package com.Booysen31SA.services.school.impl;

import com.Booysen31SA.domain.school.Transfer;
import com.Booysen31SA.repository.school.ITransfer;
import com.Booysen31SA.services.school.ITransferRetirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("TransferServiceImpl")
public class TransferServiceImpl implements ITransferRetirement {


    private static TransferServiceImpl service = null;
    @Autowired
    private ITransfer repository;
    
    public TransferServiceImpl(){

    }
    public static TransferServiceImpl getService(){
        if(service == null){
            return new TransferServiceImpl();
        }
        return service;
    }

    @Override
    public Transfer create(Transfer appointment) {
        return this.repository.save(appointment);
    }

    @Override
    public Transfer read(String integer) {
        return this.repository.findById(integer).orElse(null);
    }

    @Override
    public Transfer update(Transfer appointment) {
        return this.repository.save(appointment);
    }

    @Override
    public void delete(String integer) {

        repository.deleteById(integer);
    }

    @Override
    public Set<Transfer> getAll() {
        List<Transfer> list = (List<Transfer>) repository.findAll();

        return new HashSet<>(list);
    }
}
