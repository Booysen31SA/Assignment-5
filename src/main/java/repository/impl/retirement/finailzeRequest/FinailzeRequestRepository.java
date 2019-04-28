package repository.impl.retirement.finailzeRequest;


import domain.retirement.FinalizeRequest;
import repository.IRepository;

import java.util.Set;

public interface FinailzeRequestRepository extends IRepository<FinalizeRequest, Integer> {

    Set<FinalizeRequest> getAll();
}
