package com.Booysen31SA.services.teacher.users;

import com.Booysen31SA.domain.teacher.user.User;
import com.Booysen31SA.repository.teacher.users.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("UserServiceImpl")
public class UserServiceImpl implements IUserService {
    private static UserServiceImpl service = null;
    private UserRepository repository;

    public UserServiceImpl(){
        repository = UserRepository.getRepository();
    }
    public static UserServiceImpl getService(){
        if(service == null){
            return new UserServiceImpl();
        }
        return service;
    }

    @Override
    public Set<User> getAll() {
        return null;
    }

    @Override
    public User create(User gender) {
        return repository.create(gender);
    }

    @Override
    public User read(String integer) {
        return repository.read(integer);
    }

    @Override
    public User update(User gender) {
        return repository.update(gender);
    }

    @Override
    public void delete(String integer) {
        repository.delete(integer);
    }
}
