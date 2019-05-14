package com.Booysen31SA.repository.impl.retirement.putRequest;

import com.Booysen31SA.domain.retirement.PutRequest;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PutRequestRepositoryImpl implements PutRequestRepository {

    private static PutRequestRepositoryImpl repository = null;
    private Map<Integer, PutRequest> putRequests;

    private PutRequestRepositoryImpl(){
        this.putRequests = new HashMap<>();
    }

    public static PutRequestRepositoryImpl getPutRequest(){
        if(repository == null) repository = new PutRequestRepositoryImpl();
        return repository;
    }

    @Override
    public Set<PutRequest> getAll() {
        Collection<PutRequest> putRequests = this.putRequests.values();
        Set<PutRequest> set = new HashSet<>();
        set.addAll(putRequests);
        return set;
    }

    @Override
    public PutRequest create(PutRequest putRequest) {
        putRequests.put(putRequest.getPersal_Num(), putRequest);
        return putRequest;
    }

    @Override
    public PutRequest update(PutRequest putRequest) {
        putRequests.replace(putRequest.getPersal_Num(), putRequest);
        return putRequest;
    }

    @Override
    public void delete(Integer id) {
        putRequests.remove(id);
    }

    @Override
    public PutRequest read(Integer id) {
        return this.putRequests.get(id);
    }

}
