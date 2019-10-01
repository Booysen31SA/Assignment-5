package com.Booysen31SA.controller.school;

import com.Booysen31SA.domain.school.Status;
import com.Booysen31SA.domain.school.Transfer;

public class TransferCreation {
    private Transfer transfer;
    private Status status;

    public TransferCreation(Transfer transfer, Status status) {
        this.transfer = transfer;
        this.status = status;
    }

    public Transfer getTransfer() {
        return transfer;
    }

    public Status getStatus() {
        return status;
    }
}
