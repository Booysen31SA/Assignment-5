package com.Booysen31SA.services.impl.retirement.finalizeRequest;

import com.Booysen31SA.domain.retirement.FinalizeRequest;
import com.Booysen31SA.services.impl.IService;

import java.util.Set;

public interface FinalizeRequestService extends IService<FinalizeRequest, Integer>  {
    Set<FinalizeRequest> getAll();
}
