package repository.impl.retirement.putRequest;

import domain.retirement.PutRequest;

import java.util.HashSet;
import java.util.Set;

public class PutRequestRepositoryImpl implements PutRequestReposity {

    private static PutRequestRepositoryImpl repository = null;
    Set<PutRequest> putRequests;

    private PutRequestRepositoryImpl(){
        this.putRequests = new HashSet<>();
    }

    public static PutRequestRepositoryImpl getPutRequest(){
        if(repository == null) repository = new PutRequestRepositoryImpl();
        return repository;
    }

    @Override
    public Set<PutRequest> getAll() {
        return putRequests;
    }

    @Override
    public PutRequest create(PutRequest putRequest) {
        putRequests.add(putRequest);
        return putRequest;
    }

    @Override
    public PutRequest update(PutRequest putRequest) {
        PutRequest find = search(putRequest.getPersal_Num());
        if(putRequests.contains(find)){
            putRequests.remove(find);
            putRequests.add(putRequest);
        }
        return putRequest;
    }

    @Override
    public void delete(Integer id) {
        putRequests.remove(search(id));
    }

    @Override
    public PutRequest read(Integer id) {
        return search(id);
    }

    public PutRequest search(Integer id){
        return putRequests.stream().filter(putRequest -> putRequest.getPersal_Num() == id).findAny().orElse(null);
    }
}
