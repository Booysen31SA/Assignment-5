package com.Booysen31SA.factory.teacher.user.address;

import com.Booysen31SA.domain.teacher.user.address.Address;

public class AddressFactory {

    public static Address buildAddress(String persal_Number, String physicalAddress, String postalAddress){
        return new Address.Builder()
                   .persal_Number(persal_Number)
                   .physicalAddress(physicalAddress)
                   .postalAddress(postalAddress)
                   .build();
    }
}
