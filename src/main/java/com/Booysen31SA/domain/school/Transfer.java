package com.Booysen31SA.domain.school;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transfer implements School, Person {
    @Id
    private String persalNumber;
    private String previousSchool;
    private String schoolName;
    private int teacherAmount;

    public Transfer() {
    }

    public Transfer(String persalNumber, String previousSchool, String schoolName, int teacherAmount) {
        this.persalNumber = persalNumber;
        this.previousSchool = previousSchool;
        this.schoolName = schoolName;
        this.teacherAmount = teacherAmount;
    }

    public Transfer(Builder build) {
        this.persalNumber = build.persalNumber;
        this.previousSchool = build.previousSchool;
        this.schoolName = build.schoolName;
        this.teacherAmount = build.teacherAmount;
    }


    public String getSchoolName(){
        return schoolName;
    }

    public int getTeacherAmount() {
        return teacherAmount;
    }

    @Override
    public String getPreviousSchool() {
        return previousSchool;
    }

    @Override
    public String getPersalNumber() {
        return persalNumber;
    }

    public static class Builder{

        private String persalNumber;
        private String previousSchool;
        private String schoolName;
        private int teacherAmount;

        public Builder setPreviousSchool(String previousSchool){
            this.previousSchool = previousSchool;
            return this;
        }
        public Builder setpersalNumber(String persalNumber){
            this.persalNumber = persalNumber;
            return this;
        }
        public Builder setSchoolName(String schoolName){
            this.schoolName = schoolName;
            return this;
        }

        public Builder setTeacherAmount(int teacherAmount){
            this.teacherAmount = teacherAmount;
            return this;
        }


        public Transfer build() {
            return new Transfer(this);
        }
    }

    @Override
    public String toString() {
        return
                "pasal Number       :" + persalNumber+
                "\nPrevious Transfer:"+ previousSchool+
                "\nTransfer Name    :" + schoolName+
                "\nteacherAmount    :" + teacherAmount;
    }
}
