package com.Booysen31SA.repository.teacher.users.userRole;

import com.Booysen31SA.domain.teacher.user.Role.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRole extends CrudRepository<UserRole, String> {
}
