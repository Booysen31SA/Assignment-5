package com.Booysen31SA.factory.retirement;

import com.Booysen31SA.domain.retirement.Retirement;

public class RetirementFactory {
    public static Retirement buildRetirement(String persal_Num, String id, String firstName, String lastName, double payout){
         return new Retirement.Builder()
                    .persal_Num(persal_Num)
                    .id(id)
                    .firstName(firstName)
                    .lastName(lastName)
                    .payout(payout)
                    .build();
    }
}