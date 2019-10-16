package com.Booysen31SA.services.teacher.users.userRole.Impl;

import com.Booysen31SA.domain.teacher.user.Role.UserRole;
import com.Booysen31SA.domain.teacher.user.User;
import com.Booysen31SA.repository.teacher.users.userRole.IUserRole;
import com.Booysen31SA.services.teacher.users.IUserService;
import com.Booysen31SA.services.teacher.users.userRole.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("UserRoleServiceImpl")
public class UserRoleServiceImpl implements IUserRoleService {

    private static UserRoleServiceImpl service = null;
    @Autowired
    private IUserRole repository;

    public UserRoleServiceImpl(){

    }
    public static UserRoleServiceImpl getService(){
        if(service == null){
            return new UserRoleServiceImpl();
        }
        return service;
    }
    @Override
    public Set<UserRole> getAll() {
        List<UserRole> list = (List<UserRole>) repository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public UserRole create(UserRole account) {
        return repository.save(account);
    }

    @Override
    public UserRole read(String integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public UserRole update(UserRole account) {
        return repository.save(account);
    }

    @Override
    public void delete(String integer) {
        repository.deleteById(integer);
    }
}
