package domain.Teacher;

public class Teacher implements TeacherName, TeacherIdentity{

    TeacherAddress addr;
    Demographics demo;
    TeacherPhoneNumber phone;
    private int persal_Num;
    private String date_Of_Birth;
    private String first_Name;
    private String last_Name;
    private String iD;


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
        phone = new TeacherPhoneNumber(build.cellNumber, build.homeNumber);
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
        //other class
        private String physicalAddress;
        private String postalAddress;
        //other class
        private String gender;
        private String race;
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
                "\nrace            :"+demo.getGender()+
                "\nCell Number     :"+phone.getCellNumber()+
                "\nHome Number     :"+phone.getHomeNumber();

    }
}