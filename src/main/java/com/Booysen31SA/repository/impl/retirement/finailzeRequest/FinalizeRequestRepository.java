package com.Booysen31SA.repository.impl.retirement.finailzeRequest;


import com.Booysen31SA.domain.retirement.FinalizeRequest;
import com.Booysen31SA.repository.impl.IRepository;

import java.util.Set;

public interface FinalizeRequestRepository extends IRepository<FinalizeRequest, Integer> {

    Set<FinalizeRequest> getAll();
}
