package com.Booysen31SA.repository.teacher.users;

import com.Booysen31SA.domain.teacher.user.User;
import com.Booysen31SA.repository.teacher.users.appointed.impl.AppointedRepositoryImpl;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("UserInMemory")
public class UserRepository implements IUserRepository {

    private static UserRepository UserRepository = null;
    private Set<User> userDB;

    public UserRepository(){
        userDB = new HashSet<>();
    }

    public static UserRepository getRepository(){
        if(UserRepository == null){
            return new UserRepository();
        }
        return UserRepository;
    }

    @Override
    public Set<User> getAll() {
        return userDB;
    }

    @Override
    public User create(User User) {
        if(read(User.getPersal_Number()) == null){
            userDB.add(User);
        }
        return User;
    }

    @Override
    public User read(String integer) {
        return userDB.stream().filter(User -> User.getPersal_Number().equalsIgnoreCase(integer)).findAny().orElse(null);
    }

    @Override
    public User update(User User) {
        if(read(User.getPersal_Number()) != null){
            delete(User.getPersal_Number());
            create(User);
        }
        return User;
    }

    @Override
    public void delete(String integer) {
        if(read(integer) != null){
            User g = read(integer);
            userDB.remove(g);
        }
    }
}