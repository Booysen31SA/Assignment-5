package com.Booysen31SA.services.teacher.users.address;

import com.Booysen31SA.domain.teacher.user.address.Address;
import com.Booysen31SA.repository.IRepository;
import com.Booysen31SA.services.IService;

import java.util.Set;

public interface IAddressService extends IService<Address, String> {
    Set<Address> getAll();
}
