package repository.impl.teacher;

import domain.teacher.Teacher;
import repository.IRepository;

import java.util.Set;

public interface TeacherRepository extends IRepository<Teacher, Integer> {
  Set<Teacher> getAll();
}
