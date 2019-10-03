package com.Booysen31SA.services.teacher.users.address.impl;

import com.Booysen31SA.domain.teacher.user.address.Address;
import com.Booysen31SA.repository.teacher.users.address.IAddressRepository;
import com.Booysen31SA.services.teacher.users.address.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("AddressServiceImpl")
public class AddressServiceImpl implements IAddressService {

    private static AddressServiceImpl service = null;
    @Autowired
    private IAddressRepository repository;

    public AddressServiceImpl() {

    }

    public static AddressServiceImpl getService() {
        if (service == null) {
            return new AddressServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Address> getAll() {
        List<Address> list = (List<Address>) repository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public Address create(Address account) {
        return repository.save(account);
    }

    @Override
    public Address read(String integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public Address update(Address account) {
        return repository.save(account);
    }

    @Override
    public void delete(String integer) {
        repository.deleteById(integer);
    }
}