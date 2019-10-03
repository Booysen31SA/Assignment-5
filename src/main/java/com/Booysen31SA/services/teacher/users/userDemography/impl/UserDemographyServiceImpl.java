package com.Booysen31SA.services.teacher.users.userDemography.impl;

import com.Booysen31SA.domain.teacher.user.userDemography.UserDemography;
import com.Booysen31SA.repository.teacher.users.userDemography.IUserDemography;
import com.Booysen31SA.services.teacher.users.userDemography.IUserDemographyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("UserDemographyServiceImpl")
public class UserDemographyServiceImpl implements IUserDemographyService {
    private static UserDemographyServiceImpl service = null;
    @Autowired
    private IUserDemography repository;

    public UserDemographyServiceImpl(){

    }
    public static UserDemographyServiceImpl getService(){
        if(service == null){
            return new UserDemographyServiceImpl();
        }
        return service;
    }

    @Override
    public Set<UserDemography> getAll() {
        List<UserDemography> list = (List<UserDemography>) repository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public UserDemography create(UserDemography account) {
        return repository.save(account);
    }

    @Override
    public UserDemography read(String integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public UserDemography update(UserDemography account) {
        return repository.save(account);
    }

    @Override
    public void delete(String integer) {
        repository.deleteById(integer);
    }
}
