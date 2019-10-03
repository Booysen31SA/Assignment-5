package com.Booysen31SA.repository.teacher.users;

import com.Booysen31SA.domain.teacher.user.User;
import com.Booysen31SA.repository.IRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<User, String> {
}
