package com.Booysen31SA.services.retirement;

import com.Booysen31SA.domain.retirement.Retirement;
import com.Booysen31SA.repository.IRepository;
import com.Booysen31SA.services.IService;

import java.util.Set;

public interface IRetirementService extends IService<Retirement, String> {
    Set<Retirement> getAll();
}
