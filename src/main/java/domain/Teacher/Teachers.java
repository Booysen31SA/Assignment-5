package domain.Teacher;

import domain.Schools.School;

import java.util.Set;

public class Teachers {

    private int persal_Num;
    private String first_Name;
    private String last_Name;
    private String date_Of_Birth;
    private String iD;
    private Set<School> school;

    protected Teachers() {
    }

    public Teachers(Builder build) {
        this.persal_Num = build.persal_Num;
        this.first_Name = build.first_Name;
        this.last_Name = build.last_Name;
        this.date_Of_Birth = build.date_Of_Birth;
        this.iD = build.iD;
    }

    public int getPersal_Num() {
        return persal_Num;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public String getDate_Of_Birth() {
        return date_Of_Birth;
    }

    public String getiD() {
        return iD;
    }

    public static class Builder{

        private int persal_Num;
        private String first_Name;
        private String last_Name;
        private String date_Of_Birth;
        private String iD;

        public Builder setPersalNum(int persal_Num){
            this.persal_Num = persal_Num;
            return this;
    }

    public Builder setFirst_Name(String first_Name){
            this.first_Name = first_Name;
            return this;
    }

        public Builder setLast_Name(String last_Name){
            this.last_Name = last_Name;
            return this;
        }

        public Builder setDate_Of_Birth(String date_Of_Birth){
            this.date_Of_Birth = date_Of_Birth;
            return this;
        }

        public Builder setID(String iD){
            this.iD = iD;
            return this;
        }

        public Teachers build() {
            return new Teachers(this);
        }

    }
}
