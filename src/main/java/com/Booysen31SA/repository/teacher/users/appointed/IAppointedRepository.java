package com.Booysen31SA.repository.teacher.users.appointed;

import com.Booysen31SA.domain.teacher.user.appointed.DateAppointed;
import com.Booysen31SA.repository.IRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointedRepository extends CrudRepository<DateAppointed, String> {
}
