package repository.impl.teacher;

import domain.teacher.Teacher;

import java.util.HashSet;
import java.util.Set;

public class TeacherRepositoryImpl implements TeacherRepository {

       private static TeacherRepositoryImpl repository = null;
       private Set<Teacher> teachers;

    private TeacherRepositoryImpl() {
        this.teachers = new HashSet<>();
    }

    public static TeacherRepositoryImpl getRepository(){
        if(repository == null) repository = new TeacherRepositoryImpl();
        return repository;
    }


    @Override
    public Set<Teacher> getAll() {
        return teachers;
    }

    @Override
    public Teacher create(Teacher teacher) {
        this.teachers.add(teacher);
        return teacher;
    }

    @Override
    public Teacher update(Teacher teacher) {
        Teacher find = search(teacher.getPersal_Num());
        if(teachers.contains(find)){
            teachers.remove(find);
            teachers.add(teacher);
        }
        return teacher;
    }

    @Override
    public void delete(Integer id) {
        teachers.remove(search(id));
    }

    @Override
    public Teacher read(Integer id) {
      return search(id);
    }

    public Teacher search(int id){
        return teachers.stream().filter(teachers -> teachers.getPersal_Num() == id).findAny().orElse(null);
    }

}
