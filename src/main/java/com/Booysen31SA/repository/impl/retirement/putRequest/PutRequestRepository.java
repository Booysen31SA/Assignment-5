package com.Booysen31SA.repository.impl.retirement.putRequest;

import com.Booysen31SA.domain.retirement.PutRequest;
import com.Booysen31SA.repository.impl.IRepository;

import java.util.Set;

public interface PutRequestRepository extends IRepository<PutRequest, Integer> {

    Set<PutRequest> getAll();
}
