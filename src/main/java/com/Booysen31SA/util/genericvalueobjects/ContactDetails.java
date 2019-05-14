package com.Booysen31SA.util.genericvalueobjects;

public class ContactDetails {

    private String cellNumber;
    private String homeNumber;

    public ContactDetails(Builder build) {
        this.cellNumber = build.cellNumber;
        this.homeNumber = build.homeNumber;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public static class Builder{

        private String cellNumber;
        private String homeNumber;

        public Builder setCellNumber(String cellNum){
            this.cellNumber = cellNum;
            return this;
        }

        public Builder setHomeNumber(String homeNumb){
            this.homeNumber = homeNumb;
            return this;
        }

        public ContactDetails build(){return new ContactDetails(this);}
    }
}
