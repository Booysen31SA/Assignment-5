package com.Booysen31SA.repository.teacher.demography;

import com.Booysen31SA.domain.teacher.demography.Race;
import com.Booysen31SA.repository.IRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface IRaceRepository extends CrudRepository<Race, String> {
}
