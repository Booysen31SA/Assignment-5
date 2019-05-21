package com.Booysen31SA.services.impl.retirement.finalizeRequest;

import com.Booysen31SA.domain.retirement.FinalizeRequest;
import com.Booysen31SA.repository.impl.retirement.finailzeRequest.FinalizeRequestRepository;
import com.Booysen31SA.repository.impl.retirement.finailzeRequest.FinalizeRequestRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("FinalizeRequestServiceImpl")
public class FinalizeRequestServiceImpl implements FinalizeRequestService {

    private FinalizeRequestServiceImpl services = null;
    private FinalizeRequestRepository repository;

    public FinalizeRequestServiceImpl(){this.repository = FinalizeRequestRepositoryImpl.getFinalizeRequest();
    }

    public FinalizeRequestServiceImpl getService(){
        if(services == null) services = new FinalizeRequestServiceImpl();
        return services;
    }
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
