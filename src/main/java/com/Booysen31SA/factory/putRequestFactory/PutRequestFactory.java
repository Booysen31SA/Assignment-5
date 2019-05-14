package com.Booysen31SA.factory.putRequestFactory;

import com.Booysen31SA.domain.retirement.PutRequest;

public class PutRequestFactory {

    public static PutRequest requestAdd(int pasal, String id, String fName, String lName, double pay){
        return new PutRequest.Builder().setPasalNumber(pasal)
                                       .setFirstName(fName)
                                       .setLastName(lName)
                                       .setPayout(pay)
                                       .setStatus("Pending")
                                       .setId(id).build();
    }
}
