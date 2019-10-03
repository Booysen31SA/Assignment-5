package com.Booysen31SA.domain.teacher.user.address;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
    @Id
    private String persal_Number;
    private String physicalAddress;
    private String postalAddress;

    public Address() {
    }

    public Address(Builder build){
        this.persal_Number = build.persal_Number;
        this.physicalAddress = build.physicalAddress;
        this.postalAddress = build.postalAddress;
    }

    public Address(String persal_Number, String physicalAddress, String postalAddress) {
        this.persal_Number = persal_Number;
        this.physicalAddress = physicalAddress;
        this.postalAddress = postalAddress;
    }

    public String getPersal_Number() {
        return persal_Number;
    }
    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public static class Builder{
        String persal_Number;
        String physicalAddress;
        String postalAddress;

        public Builder persal_Number(String persal_Number) {
            this.persal_Number = persal_Number;
            return this;
        }
        public Builder physicalAddress(String physicalAddress) {
            this.physicalAddress = physicalAddress;
            return this;
        }
        public Builder postalAddress(String postalAddress) {
            this.postalAddress = postalAddress;
            return this;
        }
        public Address build() {
            return new Address(this);
        }
    }
}
