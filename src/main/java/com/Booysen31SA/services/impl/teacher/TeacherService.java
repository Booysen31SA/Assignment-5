package com.Booysen31SA.services.impl.teacher;

import com.Booysen31SA.domain.teacher.Teacher;
import com.Booysen31SA.services.impl.IService;

import java.util.Set;

public interface TeacherService extends IService<Teacher, Integer> {
    Set<Teacher> getAll();
}
