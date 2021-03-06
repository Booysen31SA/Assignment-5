package com.Booysen31SA.services.teacher.users.appointed;

import com.Booysen31SA.domain.teacher.user.appointed.DateAppointed;
import com.Booysen31SA.repository.IRepository;
import com.Booysen31SA.services.IService;

import java.util.Set;

public interface IAppointedService extends IService<DateAppointed, String> {
    Set<DateAppointed> getAll();
}
