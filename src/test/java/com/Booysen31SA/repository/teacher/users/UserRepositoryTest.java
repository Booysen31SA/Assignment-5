package com.Booysen31SA.repository.teacher.users;

import com.Booysen31SA.domain.teacher.user.User;
import com.Booysen31SA.factory.teacher.user.UserFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserRepositoryTest {

    private User user;
    private UserRepository repository;

    @Before
    public void setUp() throws Exception {
        repository = UserRepository.getRepository();
    }
    @Test
    public void getUserRepository() {
        repository = UserRepository.getRepository();
    }

    @Test
    public void create() {
        user = UserFactory.buildUser("216062241", "51515415458L","sdvsdvvsvd", "dvvvvsdvsd");
        repository.create(user);
        assertNotNull(repository.read(user.getPersal_Number()));
    }

    @Test
    public void read() {
        user = UserFactory.buildUser("216062241", "51515415458L","sdvsdvvsvd", "dvvvvsdvsd");
        repository.create(user);
        assertNotNull(repository.read(user.getPersal_Number()));
    }

    @Test
    public void update() {
        user = UserFactory.buildUser("216062241", "51515415458L","Matthew", "dvvvvsdvsd");
        User Updated = UserFactory.buildUser("216062241", "51515415458L","Matthew", "sdvsd");
        repository.create(user);
        repository.update(Updated);

        User d = repository.read(user.getPersal_Number());
        assertNotSame(user.getLast_Name(), d.getLast_Name());
    }

    @Test
    public void delete() {
        user = UserFactory.buildUser("216062241", "51515415458L","sdvsdvvsvd", "dvvvvsdvsd");
        repository.create(user);
        repository.delete(user.getPersal_Number());
        assertNull(repository.read(user.getPersal_Number()));
    }

    @Test
    public void getAll() {
        user = UserFactory.buildUser("216062241", "51515415458L","sdvsdvvsvd", "dvvvvsdvsd");
        repository.create(user);
        assertNotNull(repository.getAll());
    }
}