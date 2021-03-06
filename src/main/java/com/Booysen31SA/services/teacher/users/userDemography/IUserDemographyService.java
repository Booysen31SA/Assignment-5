package com.Booysen31SA.services.teacher.users.userDemography;

import com.Booysen31SA.domain.teacher.user.userDemography.UserDemography;
import com.Booysen31SA.repository.IRepository;
import com.Booysen31SA.services.IService;

import java.util.Set;

public interface IUserDemographyService extends IService<UserDemography, String> {
    Set<UserDemography> getAll();
}
