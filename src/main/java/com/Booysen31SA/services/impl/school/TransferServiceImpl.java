package com.Booysen31SA.services.impl.school;

import com.Booysen31SA.domain.school.Transfer;
import com.Booysen31SA.repository.impl.school.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("TransferServiceImpl")
public class TransferServiceImpl implements TransferService {
    @Autowired
    private SchoolRepository repository;

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
