package com.Booysen31SA.controller.retirement;

import com.Booysen31SA.domain.retirement.Retirement;
import com.Booysen31SA.domain.retirement.Status;
import com.Booysen31SA.factory.retirement.RetirementFactory;

public class RetirementCreation {

    private Retirement retirement;
    private Status status;

    public RetirementCreation(Retirement retirement, Status status) {
        this.retirement = RetirementFactory.buildRetirement(retirement.getPersal_Num(), retirement.getiD(), retirement.getFirstName(), retirement.getLastName(), retirement.getPayout());
        this.status = status;
    }

    public Retirement getRetirement() {
        return retirement;
    }

    public Status getStatus() {
        return status;
    }
}
