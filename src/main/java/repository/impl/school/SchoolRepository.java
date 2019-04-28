package repository.impl.school;

import domain.school.School;
import domain.school.Transfer;
import repository.IRepository;

import java.util.Set;

public interface SchoolRepository extends IRepository<Transfer, Integer > {
    Set<Transfer> getAll();
}
