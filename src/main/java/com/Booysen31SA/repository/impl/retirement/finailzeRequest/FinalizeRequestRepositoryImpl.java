package com.Booysen31SA.repository.impl.retirement.finailzeRequest;

import com.Booysen31SA.domain.retirement.FinalizeRequest;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository("Final")
public class FinalizeRequestRepositoryImpl implements FinalizeRequestRepository {

    private static FinalizeRequestRepositoryImpl repository = null;
    private Map<Integer, FinalizeRequest> finalizeRequests;

   private FinalizeRequestRepositoryImpl(){
       this.finalizeRequests = new HashMap<>();
   }

   public static FinalizeRequestRepositoryImpl getFinalizeRequest(){
       if(repository == null) repository = new FinalizeRequestRepositoryImpl();
       return repository;
   }


    @Override
    public Set<FinalizeRequest> getAll() {
        Collection<FinalizeRequest> finalize = this.finalizeRequests.values();
        Set<FinalizeRequest> set = new HashSet<>();
        set.addAll(finalize);
        return set;
    }

    @Override
    public FinalizeRequest create(FinalizeRequest finalizeRequest) {
        finalizeRequests.put(finalizeRequest.getPersal_Num(), finalizeRequest);
        return finalizeRequest;
    }

    @Override
    public FinalizeRequest update(FinalizeRequest finalizeRequest) {
        finalizeRequests.replace(finalizeRequest.getPersal_Num(), finalizeRequest);
        return finalizeRequest;
    }

    @Override
    public void delete(Integer id){
       finalizeRequests.remove(id);
    }

    @Override
    public FinalizeRequest read(Integer id) {
        return this.finalizeRequests.get(id);
    }

}
