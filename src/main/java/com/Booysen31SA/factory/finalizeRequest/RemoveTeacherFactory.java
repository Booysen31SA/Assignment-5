package com.Booysen31SA.factory.finalizeRequest;

import com.Booysen31SA.domain.retirement.FinalizeRequest;

public class RemoveTeacherFactory {

    public static FinalizeRequest remove(int pasal){
        return new FinalizeRequest.Builder().setPasalNumber(pasal)
                                        .build();
    }
}
