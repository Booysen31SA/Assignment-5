package com.Booysen31SA.controller.school;

import com.Booysen31SA.domain.school.Status;
import com.Booysen31SA.domain.school.Transfer;
import com.Booysen31SA.factory.school.TransferFactory;

public class TransferCreation {
    private Transfer transfer;
    private Status status;

    public TransferCreation(Transfer transfer, Status status) {
        this.transfer = TransferFactory.buildTransfer(transfer.getPersalNumber(), transfer.getPersalNumber(), transfer.getSchoolName(), transfer.getTeacherAmount());
        this.status = status;
    }

    public Transfer getTransfer() {
        return transfer;
    }

    public Status getStatus() {
        return status;
    }
}
