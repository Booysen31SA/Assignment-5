package com.Booysen31SA.repository.school;

import com.Booysen31SA.domain.school.Transfer;
import com.Booysen31SA.repository.IRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransfer extends CrudRepository<Transfer, String> {
}
