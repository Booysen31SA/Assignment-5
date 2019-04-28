package repository.impl.retirement.putRequest;

import domain.retirement.PutRequest;
import repository.IRepository;

import java.util.Set;

public interface PutRequestReposity extends IRepository<PutRequest, Integer> {

    Set<PutRequest> getAll();
}
