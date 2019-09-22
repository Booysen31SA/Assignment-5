package com.Booysen31SA.repository.retirement.impl;

import com.Booysen31SA.domain.retirement.Retirement;
import com.Booysen31SA.repository.retirement.IRetirementRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("RetirementInMemory")
public class RetirementRepositoryImpl implements IRetirementRepository {

    private Set<Retirement> retirementDB;
    private static RetirementRepositoryImpl RetirementRepository = null;

    private RetirementRepositoryImpl() {
        this.retirementDB = new HashSet<>();
    }

    public static RetirementRepositoryImpl getRetirementRepository() {
        if (RetirementRepository == null) RetirementRepository = new RetirementRepositoryImpl();
        return RetirementRepository;
    }
    @Override
    public Retirement create(Retirement retirement) {
        if(read(retirement.getPersal_Num()) == null){
            retirementDB.add(retirement);
        }
        return retirement;
    }

    @Override
    public Retirement read(String s) {
        return retirementDB.stream().filter(retirement -> retirement.getPersal_Num() == s).findAny().orElse(null);

    }

    @Override
    public Retirement update(Retirement retirement) {
        if(read(retirement.getPersal_Num()) != null){
            delete(retirement.getPersal_Num());
            create(retirement);
        }
        return retirement;
    }

    @Override
    public void delete(String s) {
        Retirement appointment = read(s);
        if(appointment != null){
            retirementDB.remove(appointment);
        }
    }

    @Override
    public Set<Retirement> getAll() {
        return retirementDB;
    }
}