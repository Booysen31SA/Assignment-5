package com.Booysen31SA.services.teacher.users;

import com.Booysen31SA.domain.teacher.user.Role.UserRole;
import com.Booysen31SA.domain.teacher.user.User;
import com.Booysen31SA.repository.IRepository;
import com.Booysen31SA.services.IService;

import java.util.Set;

public interface IUserService extends IService<User, String> {
    Set<User> getAll();
}
