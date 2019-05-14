package com.Booysen31SA.services.impl.retirement.finalizeRequest;

import com.Booysen31SA.domain.retirement.FinalizeRequest;
import com.Booysen31SA.repository.impl.retirement.finailzeRequest.FinalizeRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FinalizeRequestServiceImpl implements FinalizeRequestService {
    @Autowired
    private FinalizeRequestRepository repository;
    @Override
    public Set<FinalizeRequest> getAll() {
        return repository.getAll();
    }

    @Override
    public FinalizeRequest create(FinalizeRequest finalizeRequest) {
        return  repository.create(finalizeRequest);
    }

    @Override
    public FinalizeRequest update(FinalizeRequest finalizeRequest) {
        return repository.update(finalizeRequest);
    }

    @Override
    public void delete(Integer integer) {
    repository.delete(integer);
    }

    @Override
    public FinalizeRequest read(Integer integer) {
        return repository.read(integer);
    }
}
