package com.Booysen31SA.repository.teacher.users.userDemography;

import com.Booysen31SA.domain.teacher.user.userDemography.UserDemography;
import com.Booysen31SA.repository.IRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDemography extends CrudRepository<UserDemography, String> {
}
