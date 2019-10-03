package com.Booysen31SA.services.teacher.demography;

import com.Booysen31SA.domain.teacher.demography.Race;
import com.Booysen31SA.repository.IRepository;
import com.Booysen31SA.services.IService;

import java.util.Set;

public interface IRaceService extends IService<Race, String> {
    Set<Race> getAll();
}
