package com.Booysen31SA.repository.appointment;

import com.Booysen31SA.domain.appointment.Reason;
import com.Booysen31SA.repository.IRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReasonRepository extends CrudRepository<Reason, String> {
}
