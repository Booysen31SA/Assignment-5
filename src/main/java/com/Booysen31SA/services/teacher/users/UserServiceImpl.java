package com.Booysen31SA.services.teacher.users;

import com.Booysen31SA.domain.teacher.user.User;
import com.Booysen31SA.repository.teacher.users.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service("UserServiceImpl")
public class UserServiceImpl implements IUserService {
    private static UserServiceImpl service = null;
    @Autowired
    private IUserRepository repository;

    public UserServiceImpl(){

    }
    public static UserServiceImpl getService(){
        if(service == null){
            return new UserServiceImpl();
        }
        return service;
    }

    @Override
    public Set<User> getAll() {
        List<User> list = (List<User>) repository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public User create(User account) {
        return repository.save(account);
    }

    @Override
    public User read(String integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public User update(User account) {
        return repository.save(account);
    }

    @Override
    public void delete(String integer) {
        repository.deleteById(integer);
    }
}
