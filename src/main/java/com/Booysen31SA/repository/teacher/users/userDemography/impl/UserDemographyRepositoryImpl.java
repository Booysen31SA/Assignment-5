package com.Booysen31SA.repository.teacher.users.userDemography.impl;

import com.Booysen31SA.domain.teacher.user.userDemography.UserDemography;
import com.Booysen31SA.repository.teacher.users.userDemography.IUserDemography;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("UserDemographyInMemory")
public class UserDemographyRepositoryImpl implements IUserDemography {
    private static UserDemographyRepositoryImpl UserDemographyRepository = null;
    Set<UserDemography> UserDemographys;
    public UserDemographyRepositoryImpl(){
        UserDemographys = new HashSet<>();
    }

    public static UserDemographyRepositoryImpl getRepository(){
        if(UserDemographyRepository == null){
            return new UserDemographyRepositoryImpl();
        }
        return UserDemographyRepository;
    }

    @Override
    public Set<UserDemography> getAll() {
        return UserDemographys;
    }

    @Override
    public UserDemography create(UserDemography UserDemography) {
        if(read(UserDemography.getPersal_Number()) == null){
            UserDemographys.add(UserDemography);
        }
        return UserDemography;
    }

    @Override
    public UserDemography read(String integer) {
        return UserDemographys.stream().filter(UserDemography -> UserDemography.getPersal_Number() == integer).findAny().orElse(null);
    }

    @Override
    public UserDemography update(UserDemography UserDemography) {
        if(read(UserDemography.getPersal_Number()) != null){
            delete(UserDemography.getPersal_Number());
            create(UserDemography);
        }
        return UserDemography;
    }

    @Override
    public void delete(String integer) {
        if(read(integer) != null){
            UserDemography g = read(integer);
            UserDemographys.remove(g);
        }
    }
}
