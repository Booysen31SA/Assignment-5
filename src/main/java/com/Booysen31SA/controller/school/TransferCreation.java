package com.Booysen31SA.controller.school;

import com.Booysen31SA.domain.school.Status;
import com.Booysen31SA.domain.school.Transfer;
import com.Booysen31SA.factory.school.StatusFactory;
import com.Booysen31SA.factory.school.TransferFactory;

public class TransferCreation {
    private Transfer transfer;
    private Status status;

    public TransferCreation(Transfer transfer, Status status) {
        this.transfer = TransferFactory.buildTransfer(transfer.getPersalNumber(), transfer.getPreviousSchool(), transfer.getSchoolName(), transfer.getTeacherAmount());
        this.status = StatusFactory.buildStatus(transfer.getPersalNumber(), status.getStatusRequest());
    }

    public Transfer getTransfer() {
        return transfer;
    }

    public Status getStatus() {
        return status;
    }
}
