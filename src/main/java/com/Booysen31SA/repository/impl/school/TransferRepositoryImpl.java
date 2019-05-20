package com.Booysen31SA.repository.impl.school;

import com.Booysen31SA.domain.school.Transfer;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("Transfer")
public class TransferRepositoryImpl implements SchoolRepository {

    private static TransferRepositoryImpl repository = null;
    private Map<Integer, Transfer> transferTeacher;

    private TransferRepositoryImpl(){
        this.transferTeacher = new HashMap<>();
    }

    public static TransferRepositoryImpl getTransfer(){
        if(repository == null) repository = new TransferRepositoryImpl();
        return repository;
    }
    @Override
    public Set<Transfer> getAll() {
        Collection<Transfer> transfers = this.transferTeacher.values();
        Set<Transfer> set = new HashSet<>();
        set.addAll(transfers);
        return set;
    }

    @Override
    public Transfer create(Transfer transfer) {
        this.transferTeacher.put(transfer.getPersalNumber(), transfer);
        return transfer;
    }

    @Override
    public Transfer update(Transfer transfer) {
        transferTeacher.replace(transfer.getPersalNumber(), transfer);
        return transfer;
    }

    @Override
    public void delete(Integer id) {
         transferTeacher.remove(id);
    }

    @Override
    public Transfer read(Integer id) {
        return this.transferTeacher.get(id);
    }

}
