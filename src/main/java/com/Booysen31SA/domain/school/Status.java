package com.Booysen31SA.domain.school;

public class Status {

    private String persal_Number;
    private String statusRequest;

    public Status(String persal_Number, String statusRequest) {
        this.persal_Number = persal_Number;
        this.statusRequest = statusRequest;
    }

    public String getPersal_Number() {
        return persal_Number;
    }

    public void setPersal_Number(String persal_Number) {
        this.persal_Number = persal_Number;
    }

    public String getStatusRequest() {
        return statusRequest;
    }

    public void setStatusRequest(String statusRequest) {
        this.statusRequest = statusRequest;
    }
}
