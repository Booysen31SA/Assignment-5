package com.Booysen31SA.services.teacher.users.userDemography.impl;

import com.Booysen31SA.domain.teacher.user.userDemography.UserDemography;
import com.Booysen31SA.repository.teacher.users.userDemography.impl.UserDemographyRepositoryImpl;
import com.Booysen31SA.services.teacher.users.userDemography.IUserDemographyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("UserDemographyServiceImpl")
public class UserDemographyServiceImpl implements IUserDemographyService {
    private static UserDemographyServiceImpl service = null;
    private UserDemographyRepositoryImpl repository;

    public UserDemographyServiceImpl(){
        repository = UserDemographyRepositoryImpl.getRepository();
    }
    public static UserDemographyServiceImpl getService(){
        if(service == null){
            return new UserDemographyServiceImpl();
        }
        return service;
    }

    @Override
    public Set<UserDemography> getAll() {
        return repository.getAll();
    }

    @Override
    public UserDemography create(UserDemography gender) {
        return repository.create(gender);
    }

    @Override
    public UserDemography read(String integer) {
        return repository.read(integer);
    }

    @Override
    public UserDemography update(UserDemography gender) {
        return repository.update(gender);
    }

    @Override
    public void delete(String integer) {
        repository.delete(integer);
    }
}
