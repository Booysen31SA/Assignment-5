package com.Booysen31SA.services.impl.school;

import com.Booysen31SA.domain.school.Transfer;
import com.Booysen31SA.repository.impl.school.SchoolRepository;
import com.Booysen31SA.repository.impl.school.TransferRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("TransferServiceImpl")
public class TransferServiceImpl implements TransferService {

    private TransferServiceImpl services = null;
    private SchoolRepository repository;

    public TransferServiceImpl(){this.repository = TransferRepositoryImpl.getTransfer();
    }

    public TransferServiceImpl getService(){
        if(services == null) {services = new TransferServiceImpl();}
        return services;
    }

    @Override
    public Set<Transfer> getAll() {
        return repository.getAll();
    }

    @Override
    public Transfer create(Transfer transfer) {
        return repository.create(transfer);
    }

    @Override
    public Transfer update(Transfer transfer) {
        return repository.update(transfer);
    }

    @Override
    public void delete(Integer integer) {
        repository.delete(integer);
    }

    @Override
    public Transfer read(Integer integer) {
        return repository.read(integer);
    }
}
