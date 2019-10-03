package com.Booysen31SA.repository.teacher.users.address;

import com.Booysen31SA.domain.teacher.user.address.Address;
import com.Booysen31SA.repository.IRepository;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends CrudRepository<Address, String> {
}
