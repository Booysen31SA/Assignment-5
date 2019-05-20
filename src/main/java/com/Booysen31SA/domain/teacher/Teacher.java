package com.Booysen31SA.domain.teacher;

import com.Booysen31SA.util.genericvalueobjects.ContactDetails;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

public class Teacher implements TeacherName, TeacherIdentity{

    TeacherAddress addr;
    Demographics demo;
    DateAppointed dateA;
    private int persal_Num;
    private String date_Of_Birth;
    private String first_Name;
    private String last_Name ;
    private String iD;
    private ContactDetails contactDetails;



   // private Set<Transfer> school;

    protected Teacher() {
    }

    public Teacher(Builder build) {
        this.persal_Num = build.persal_Num;
        this.first_Name = build.first_Name;
        this.last_Name = build.last_Name;
        this.date_Of_Birth = build.date_Of_Birth;
        this.iD = build.iD;
        addr = new TeacherAddress(build.physicalAddress, build.postalAddress);
        demo = new Demographics(build.gender, build.race);
        dateA = new DateAppointed(build.dateA);
        this.contactDetails = build.contactDetails;
    }
    @Override
    public int getPersal_Num() {
        return persal_Num;
    }

    @Override
    public String getFirst_Name() {
        return first_Name;
    }
    @Override
    public String getLast_Name() {
        return last_Name;
    }

    public String getDate_Of_Birth() {
        return date_Of_Birth;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    @Override
    public String getiD() {
        return iD;
    }

    public static class Builder{

        private int persal_Num;
        private String first_Name;
        private String last_Name;
        private String date_Of_Birth;
        private String iD;
        private ContactDetails contactDetails;
        //other class
        private String physicalAddress;
        private String postalAddress;
        //other class
        private String gender;
        private String race;

        private String dateA;

        public Builder setDateAppointed(String date) {
            this.dateA = date;
            return this;
        }

        public Builder contactDetails(ContactDetails contactDetails) {
            this.contactDetails = contactDetails;
            return this;
        }

        public Builder setGender(String gender){
            this.gender = gender;
            return this;
        }
        public Builder setRace(String race){
            this.race = race;
            return this;
        }

        public Builder setPhysicalAddress(String physicalAddress) {
            this.physicalAddress = physicalAddress;
            return this;
        }

        public Builder setPostalAddress(String postalAddress) {
            this.postalAddress = postalAddress;
            return this;
        }

        public Builder setPersalNum(int persal_Num) {
            this.persal_Num = persal_Num;
            return this;
        }

        public Builder setFirst_Name(String first_Name) {
            this.first_Name = first_Name;
            return this;
        }

        public Builder setLast_Name(String last_Name) {
            this.last_Name = last_Name;
            return this;
        }

        public Builder setDate_Of_Birth(String date_Of_Birth) {
            this.date_Of_Birth = date_Of_Birth;
            return this;
        }

        public Builder setID(String iD) {
            this.iD = iD;
            return this;
        }

        public Teacher build() {
            return new Teacher(this);
        }


    }

    @Override
    public String toString() {
        return    "persal_Num      :" + persal_Num +
                "\nfirst_Name      :" + first_Name +
                "\nlast_Name       :" + last_Name +
                "\ndate_Of_Birth   :" + date_Of_Birth +
                "\niD              :" + iD+
                "\nPhysical Address:" + addr.getPhysicalAddress()+
                "\nPostal Address  :" + addr.getPostalAddress()+
                "\nGender          :"+demo.getGender()+
                "\nrace            :"+demo.getRace()+
                "\ncell number     :"+contactDetails.getCellNumber();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return persal_Num == teacher.persal_Num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(persal_Num);
    }
}