package com.Booysen31SA.repository.impl.teacher;

import com.Booysen31SA.domain.teacher.Teacher;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("Teacher")
public class TeacherRepositoryImpl implements TeacherRepository {

       private static TeacherRepositoryImpl repository = null;
       private Map<Integer, Teacher> teachers;

    private TeacherRepositoryImpl() {
        this.teachers = new HashMap<>();
    }

    public static TeacherRepositoryImpl getRepository(){
        if(repository == null) repository = new TeacherRepositoryImpl();
        return repository;
    }


    @Override
    public Set<Teacher> getAll() {
        Collection<Teacher> teachers = this.teachers.values();
        Set<Teacher> set = new HashSet<>();
        set.addAll(teachers);
        return set;
    }

    @Override
    public Teacher create(Teacher teacher) {
        this.teachers.put(teacher.getPersal_Num(),teacher);
        return teacher;
    }

    @Override
    public Teacher update(Teacher teacher) {
        teachers.replace(teacher.getPersal_Num(), teacher);
        return teacher;
    }

    @Override
    public void delete(Integer id) {
        teachers.remove(id);
    }

    @Override
    public Teacher read(Integer id) {
      return this.teachers.get(id);
    }


}
