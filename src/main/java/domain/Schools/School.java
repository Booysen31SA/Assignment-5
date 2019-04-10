package domain.Schools;

public class School {

    private String schoolName;
    private int teacherAmount;
    private int studentCount;

    public School(Builder build) {
        this.schoolName = build.schoolName;
        this.teacherAmount = build.teacherAmount;
        this.studentCount = build.studentCount;
    }

    public static class Builder{

        private String schoolName;
        private int teacherAmount;
        private int studentCount;

        public Builder setSchoolName(String schoolName){
            this.schoolName = schoolName;
            return this;
        }

        public Builder setTeacherAmount(int teacherAmount){
            this.teacherAmount = teacherAmount;
            return this;
        }

        public Builder setStudentCount(int studentCount){
            this.studentCount = studentCount;
            return this;
        }

        public School build() {
            return new School(this);
        }
    }
}
