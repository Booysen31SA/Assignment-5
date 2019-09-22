package com.Booysen31SA.services.teacher.users.address.impl;

import com.Booysen31SA.domain.teacher.user.address.Address;
import com.Booysen31SA.repository.teacher.users.address.impl.AddressRepositoryImpl;
import com.Booysen31SA.services.teacher.users.address.IAddressService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("AddressServiceImpl")
public class AddressServiceImpl implements IAddressService {

    private static AddressServiceImpl service = null;
    private AddressRepositoryImpl repository;

    public AddressServiceImpl() {
        repository = AddressRepositoryImpl.getRepository();
    }

    public static AddressServiceImpl getService() {
        if (service == null) {
            return new AddressServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Address> getAll() {
        return repository.getAll();
    }

    @Override
    public Address create(Address gender) {
        return repository.create(gender);
    }

    @Override
    public Address read(String integer) {
        return repository.read(integer);
    }

    @Override
    public Address update(Address gender) {
        return repository.update(gender);
    }

    @Override
    public void delete(String integer) {
        repository.delete(integer);
    }
}