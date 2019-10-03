package com.Booysen31SA.services.school;

import com.Booysen31SA.domain.school.Status;
import com.Booysen31SA.repository.IRepository;
import com.Booysen31SA.services.IService;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface IStatusRetirement extends IService<Status, String> {
    Set<Status> getAll();
}
