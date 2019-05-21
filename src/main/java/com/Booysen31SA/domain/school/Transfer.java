package com.Booysen31SA.domain.school;


public class Transfer implements School, Person {

    Status status;

    private int pasalNumber;
    private String previousSchool;
    private String schoolName;
    private int teacherAmount;

    public Transfer() {
    }

    public Transfer(Builder build) {
        this.pasalNumber = build.pasalNumber;
        this.previousSchool = build.previousSchool;
        this.schoolName = build.schoolName;
        this.teacherAmount = build.teacherAmount;
        status = new Status(build.status);

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
    public int getPersalNumber() {
        return pasalNumber;
    }

    public static class Builder{

        private int pasalNumber;
        private String previousSchool;
        private String schoolName;
        private int teacherAmount;
        private String status;

        public Builder setStatus(String status){
            this.status = status;
            return this;
        }

        public Builder setPreviousSchool(String previousSchool){
            this.previousSchool = previousSchool;
            return this;
        }
        public Builder setPasalNumber(int pasalNumber){
            this.pasalNumber = pasalNumber;
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
                "pasal Number       :" + pasalNumber+
                "\nPrevious Transfer:"+ previousSchool+
                "\nTransfer Name    :" + schoolName+
                "\nteacherAmount    :" + teacherAmount+
                "\nStatus           :" + status.getStatusRequest();
    }
}
