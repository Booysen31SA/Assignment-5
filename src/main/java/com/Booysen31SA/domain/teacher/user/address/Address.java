package com.Booysen31SA.domain.teacher.user.address;

public class Address {
    String persal_Number;
    String physicalAddress;
    String postalAddress;

    public Address(Builder build){
        this.persal_Number = build.persal_Number;
        this.physicalAddress = build.physicalAddress;
        this.postalAddress = build.postalAddress;
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
