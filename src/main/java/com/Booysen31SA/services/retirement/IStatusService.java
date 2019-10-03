package com.Booysen31SA.services.retirement;

import com.Booysen31SA.domain.retirement.Status;
import com.Booysen31SA.repository.IRepository;
import com.Booysen31SA.services.IService;

import java.util.Set;

public interface IStatusService extends IService<Status, String> {
    Set<Status> getAll();
}
