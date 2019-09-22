package com.Booysen31SA.domain.retirement;

public class Status {

    private String persal_Number;
    private String request;

    public Status(String persal_Number, String request) {
        this.persal_Number = persal_Number;
        this.request = request;
    }

    public String getPersal_Number() {
        return persal_Number;
    }

    public String getRequest() {
        return request;
    }
}
