package com.Booysen31SA.repository.teacher.demography;

import com.Booysen31SA.domain.teacher.demography.Gender;
import com.Booysen31SA.repository.IRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenderRepository extends CrudRepository<Gender, String> {
}
