package com.Booysen31SA.repository.impl.school;

import com.Booysen31SA.domain.school.Transfer;
import com.Booysen31SA.repository.impl.IRepository;

import java.util.Set;

public interface SchoolRepository extends IRepository<Transfer, Integer > {
    Set<Transfer> getAll();
}
