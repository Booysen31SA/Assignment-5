package com.Booysen31SA.services.school;

import com.Booysen31SA.domain.school.Transfer;
import com.Booysen31SA.repository.IRepository;
import com.Booysen31SA.services.IService;

import java.util.Set;

public interface ITransferRetirement extends IService<Transfer, String> {
    Set<Transfer> getAll();
}
