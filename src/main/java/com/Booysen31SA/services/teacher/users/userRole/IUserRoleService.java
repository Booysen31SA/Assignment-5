package com.Booysen31SA.services.teacher.users.userRole;

import com.Booysen31SA.domain.teacher.user.Role.UserRole;
import com.Booysen31SA.services.IService;

import java.util.Set;

public interface IUserRoleService extends IService<UserRole, String> {
    Set<UserRole> getAll();
}
