package com.Booysen31SA.services.impl.retirement.putRequest;

import com.Booysen31SA.domain.retirement.PutRequest;
import com.Booysen31SA.services.impl.IService;

import java.util.Set;

public interface PutRequestService extends IService<PutRequest, Integer> {
    Set<PutRequest> getAll();
}
