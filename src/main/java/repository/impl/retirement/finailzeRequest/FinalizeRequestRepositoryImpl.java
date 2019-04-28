package repository.impl.retirement.finailzeRequest;

import domain.retirement.FinalizeRequest;

import java.util.HashSet;
import java.util.Set;

public class FinalizeRequestRepositoryImpl implements FinailzeRequestRepository {

    private static FinalizeRequestRepositoryImpl repository = null;
    private Set<FinalizeRequest> finalizeRequests;

   private FinalizeRequestRepositoryImpl(){
       this.finalizeRequests = new HashSet<>();
   }

   public static FinalizeRequestRepositoryImpl getFinailzeRequest(){
       if(repository == null) repository = new FinalizeRequestRepositoryImpl();
       return repository;
   }


    @Override
    public Set<FinalizeRequest> getAll() {
        return finalizeRequests;
    }

    @Override
    public FinalizeRequest create(FinalizeRequest finalizeRequest) {
        finalizeRequests.add(finalizeRequest);
        return finalizeRequest;
    }

    @Override
    public FinalizeRequest update(FinalizeRequest finalizeRequest) {
        FinalizeRequest find = search(finalizeRequest.getPersal_Num());
        if(finalizeRequests.contains(find)){
            finalizeRequests.remove(find);
            finalizeRequests.add(finalizeRequest);
        }
        return finalizeRequest;
    }

    @Override
    public void delete(Integer id) {
      finalizeRequests.remove(search(id));
    }

    @Override
    public FinalizeRequest read(Integer id) {
        return search(id);
    }

    public FinalizeRequest search(Integer id){
        return finalizeRequests.stream().filter(finalizeRequests -> finalizeRequests.getPersal_Num() == id).findAny().orElse(null);
    }
}
