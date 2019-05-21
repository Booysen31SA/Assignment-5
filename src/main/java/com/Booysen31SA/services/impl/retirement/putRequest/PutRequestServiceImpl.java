package com.Booysen31SA.services.impl.retirement.putRequest;

import com.Booysen31SA.domain.retirement.PutRequest;
import com.Booysen31SA.repository.impl.retirement.putRequest.PutRequestRepository;
import com.Booysen31SA.repository.impl.retirement.putRequest.PutRequestRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("PutRequestServiceImpl")
public class PutRequestServiceImpl implements PutRequestService {

    private PutRequestServiceImpl services;
    private PutRequestRepository repository;

    public PutRequestServiceImpl(){this.repository = PutRequestRepositoryImpl.getPutRequest();}

    public PutRequestServiceImpl getService(){
        if(services == null)services = new PutRequestServiceImpl();

        return services;
    }

    @Override
    public Set<PutRequest> getAll() {
        return repository.getAll();
    }

    @Override
    public PutRequest create(PutRequest putRequest) {
        return repository.create(putRequest);
    }

    @Override
    public PutRequest update(PutRequest putRequest) {
        return repository.update(putRequest);
    }

    @Override
    public void delete(Integer integer)  {
        repository.delete(integer);
    }

    @Override
    public PutRequest read(Integer integer) {
        return repository.read(integer);
    }
}
