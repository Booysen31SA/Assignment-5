package com.Booysen31SA.services.impl.school;

import com.Booysen31SA.domain.school.Transfer;
import com.Booysen31SA.services.impl.IService;

import java.util.Set;

public interface TransferService extends IService<Transfer, Integer> {
    Set<Transfer> getAll();
}
