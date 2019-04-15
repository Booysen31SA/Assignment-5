package domain.School;

public class Transfer implements School {

    private int pasalNumber;
    private String previousSchool;
    private String schoolName;
    private int teacherAmount;


    public Transfer(Builder build) {
        this.pasalNumber = build.pasalNumber;
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

    public static class Builder{

        private int pasalNumber;
        private String previousSchool;
        private String schoolName;
        private int teacherAmount;


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
                "pasal Number   :" + pasalNumber+
                "\nPrevious Transfer:"+ previousSchool+
                "\nTransfer Name    :" + schoolName+
                "\nteacherAmount  :" + teacherAmount;
    }
}
