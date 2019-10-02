package com.Booysen31SA.factory.retirement;

import com.Booysen31SA.domain.retirement.Retirement;

public class RetirementFactory {
    public static Retirement buildRetirement(String persal_Num, String iD, String firstName, String lastName, double payout){
         return new Retirement.Builder()
                    .persal_Num(persal_Num)
                    .iD(iD)
                    .firstName(firstName)
                    .lastName(lastName)
                    .payout(payout)
                    .build();
    }
}