package com.Booysen31SA.repository.impl.teacher;

import com.Booysen31SA.domain.teacher.Teacher;
import com.Booysen31SA.repository.impl.IRepository;

import java.util.Set;

public interface TeacherRepository extends IRepository<Teacher, Integer> {
  Set<Teacher> getAll();
}
