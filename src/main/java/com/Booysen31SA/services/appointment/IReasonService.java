package com.Booysen31SA.services.appointment;

import com.Booysen31SA.domain.appointment.Reason;
import com.Booysen31SA.repository.IRepository;
import com.Booysen31SA.services.IService;

import java.util.Set;

public interface IReasonService extends IService<Reason, String> {
    Set<Reason> getAll();
}
