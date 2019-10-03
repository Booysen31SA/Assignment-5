package com.Booysen31SA.services.teacher.demography;

import com.Booysen31SA.domain.teacher.demography.Gender;
import com.Booysen31SA.repository.IRepository;
import com.Booysen31SA.services.IService;

import java.util.Set;

public interface IGenderService extends IService<Gender, String> {
    Set<Gender> getAll();
}
