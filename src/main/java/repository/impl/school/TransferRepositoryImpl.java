package repository.impl.school;

import domain.school.Transfer;

import java.util.HashSet;
import java.util.Set;

public class TransferRepositoryImpl implements SchoolRepository {

    private static TransferRepositoryImpl repository = null;
    private Set<Transfer> transferTeacher;

    private TransferRepositoryImpl(){
        this.transferTeacher = new HashSet<>();
    }

    public static TransferRepositoryImpl getTransfer(){
        if(repository == null) repository = new TransferRepositoryImpl();
        return repository;
    }
    @Override
    public Set<Transfer> getAll() {
        return transferTeacher;
    }

    @Override
    public Transfer create(Transfer transfer) {
        transferTeacher.add(transfer);
        return transfer;
    }

    @Override
    public Transfer update(Transfer transfer) {
        Transfer find = search(transfer.getPersalNumber());
        if(transferTeacher.contains(find)){
            transferTeacher.remove(find);
            transferTeacher.add(transfer);
        }
        return transfer;
    }

    @Override
    public void delete(Integer id) {
         transferTeacher.remove(search(id));
    }

    @Override
    public Transfer read(Integer id) {
        return search(id);
    }

    public Transfer search(Integer id){
        return transferTeacher.stream().filter(transfer -> transfer.getPersalNumber() == id).findAny().orElse(null);
    }
}
