package com.Booysen31SA.factory.retirement;

import com.Booysen31SA.domain.retirement.Retirement;

public class RetirementFactory {
    public static Retirement buildRetirement(String persal_Number, long id, String firstName, String lastName, double payout){
         return new Retirement.Builder()
                    .persal_Number(persal_Number)
                    .id(id)
                    .firstName(firstName)
                    .lastName(lastName)
                    .payout(payout)
                    .build();
    }
}