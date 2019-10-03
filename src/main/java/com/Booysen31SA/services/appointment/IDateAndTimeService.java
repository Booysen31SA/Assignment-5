package com.Booysen31SA.services.appointment;

import com.Booysen31SA.domain.appointment.DateAndTime;
import com.Booysen31SA.repository.IRepository;
import com.Booysen31SA.services.IService;

import java.util.Set;

public interface IDateAndTimeService extends IService<DateAndTime, String> {
    Set<DateAndTime> getAll();
}
