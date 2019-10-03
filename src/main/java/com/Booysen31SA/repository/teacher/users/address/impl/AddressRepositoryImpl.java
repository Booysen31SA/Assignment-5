//package com.Booysen31SA.repository.teacher.users.address.impl;
//
//import com.Booysen31SA.domain.teacher.user.address.Address;
//import com.Booysen31SA.repository.teacher.users.address.IAddressRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Repository("AddressInMemory")
//public class AddressRepositoryImpl implements IAddressRepository {
//
//    private static AddressRepositoryImpl AddressRepository = null;
//    Set<Address> Addresss;
//    public AddressRepositoryImpl(){
//        Addresss = new HashSet<>();
//    }
//
//    public static AddressRepositoryImpl getRepository(){
//        if(AddressRepository == null){
//            return new AddressRepositoryImpl();
//        }
//        return AddressRepository;
//    }
//
//    @Override
//    public Set<Address> getAll() {
//        return Addresss;
//    }
//
//    @Override
//    public Address create(Address Address) {
//        if(read(Address.getPersal_Number()) == null){
//            Addresss.add(Address);
//        }
//        return Address;
//    }
//
//    @Override
//    public Address read(String integer) {
//        return Addresss.stream().filter(Address -> Address.getPersal_Number().equalsIgnoreCase(integer)).findAny().orElse(null);
//    }
//
//    @Override
//    public Address update(Address Address) {
//        if(read(Address.getPersal_Number()) != null){
//            delete(Address.getPersal_Number());
//            create(Address);
//        }
//        return Address;
//    }
//
//    @Override
//    public void delete(String integer) {
//        if(read(integer) != null){
//            Address g = read(integer);
//            Addresss.remove(g);
//        }
//    }
//}
