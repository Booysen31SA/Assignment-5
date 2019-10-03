package com.Booysen31SA.repository.retirement;

import com.Booysen31SA.domain.retirement.Status;
import com.Booysen31SA.repository.IRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusRepository extends CrudRepository<Status, String> {
}
