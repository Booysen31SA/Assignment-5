package com.Booysen31SA.services.impl.teacher;

import com.Booysen31SA.domain.teacher.Teacher;
import com.Booysen31SA.repository.impl.teacher.TeacherRepository;
import com.Booysen31SA.repository.impl.teacher.TeacherRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("TeacherServiceImpl")
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherRepository repository;

    private TeacherServiceImpl(){this.repository = TeacherRepositoryImpl.getRepository();}


    @Override
    public Set<Teacher> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Teacher create(Teacher teacher) {
       return this.repository.create(teacher);
    }

    @Override
    public Teacher read(Integer id) {
       return this.repository.read(id);
    }

    @Override
    public Teacher update(Teacher teacher) {
        return this.repository.update(teacher);
    }

    @Override
    public void delete(Integer id) {
        this.repository.delete(id);
    }
}
